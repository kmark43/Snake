package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Window {
    private JFrame frame;
    private JLabel scoreLabel;
    private Canvas canvas;

    public Window(int canvasWidth, int canvasHeight) {
        frame = new JFrame();
        scoreLabel = new JLabel("Score: 0");
        canvas = new Canvas(canvasWidth, canvasHeight);
        canvas.setBorder(new LineBorder(Color.BLACK, 2));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        JPanel mainPane = new JPanel(new BorderLayout());
        JPanel northPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        northPane.add(scoreLabel);
        northPane.setBackground(Color.WHITE);
        mainPane.add(northPane, BorderLayout.NORTH);
        mainPane.add(canvas, BorderLayout.CENTER);
        frame.add(mainPane);

        frame.pack();
    }

    public void show() {
        frame.setVisible(true);
        canvas.grabFocus();
    }

    public void setScore(int score) {
        SwingUtilities.invokeLater(() -> scoreLabel.setText("Score: " + score));
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
