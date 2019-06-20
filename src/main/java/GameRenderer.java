import game.Board;
import game.BoardPos;
import game.SnakeGame;
import gui.Canvas;
import gui.Window;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GameRenderer {
    public void renderGame(Window window, SnakeGame game) {
        Canvas canvas = window.getCanvas();

        window.setScore(game.getScore());

        Graphics2D g = canvas.getBufferGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas.getBufferWidth(), canvas.getBufferHeight());

        Board board = game.getBoard();

        float tileWidth = (float)canvas.getBufferWidth() / Board.WIDTH;
        float tileHeight = (float)canvas.getBufferHeight() / Board.WIDTH;

        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                switch (board.getTile(new BoardPos(i, j))) {
                    case SNAKE:
                        g.setColor(Color.RED);
                        g.fillRect((int)(i * tileWidth), (int)(j * tileHeight), (int)tileWidth, (int)tileHeight);
                        g.setColor(Color.BLACK);
                        g.drawRect((int)(i * tileWidth), (int)(j * tileHeight), (int)tileWidth, (int)tileHeight);
                        break;
                    case FOOD:
                        g.setColor(Color.GREEN);
                        g.fillRect((int)(i * tileWidth), (int)(j * tileHeight), (int)tileWidth, (int)tileHeight);
                        g.setColor(Color.BLACK);
                        g.drawRect((int)(i * tileWidth), (int)(j * tileHeight), (int)tileWidth, (int)tileHeight);
                        break;
                }
            }
        }

        if (game.getState() == SnakeGame.GameState.ENDED) {
            g.setColor(new Color(0, 0, 0, 75));
            g.fillRect(0, 0, canvas.getBufferWidth(), canvas.getBufferHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font(g.getFont().getFamily(), Font.PLAIN, 42));
            int strWidth = g.getFontMetrics().stringWidth("Game Over");
            int strHeight = g.getFontMetrics().getHeight();
            g.drawString("Game Over",
                    (canvas.getBufferWidth() - strWidth) / 2,
                    (canvas.getBufferHeight() - strHeight) / 2);
        }

        g.dispose();
        canvas.repaint();
    }
}
