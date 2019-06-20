package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    private BufferedImage image;

    public Canvas(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public int getBufferWidth() {
        return image.getWidth();
    }

    public int getBufferHeight() {
        return image.getHeight();
    }

    public Graphics2D getBufferGraphics() {
        return image.createGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
