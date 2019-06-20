import game.SnakeGame;
import gui.KeyController;
import gui.Window;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Window window = new Window(500, 500);
        GameRenderer renderer = new GameRenderer();
        SwingUtilities.invokeLater(window::show);
        SnakeGame game = new SnakeGame();
        KeyController keyController = new KeyController(game);
        window.getCanvas().addKeyListener(keyController);

        while (true) {
            game.update();
            window.setScore(game.getScore());
            renderer.renderGame(window, game);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
        }
    }
}
