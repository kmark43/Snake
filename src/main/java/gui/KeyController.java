package gui;

import game.Direction;
import game.SnakeGame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
    private SnakeGame game;

    public KeyController(SnakeGame game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (game.getState() == SnakeGame.GameState.ENDED) {
            game.setState(SnakeGame.GameState.WAITING);
            return;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP ||
                e.getKeyCode() == KeyEvent.VK_W) {
            game.getSnake().queueDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN ||
                e.getKeyCode() == KeyEvent.VK_S) {
            game.getSnake().queueDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT ||
                e.getKeyCode() == KeyEvent.VK_A) {
            game.getSnake().queueDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT ||
                e.getKeyCode() == KeyEvent.VK_D) {
            game.getSnake().queueDirection(Direction.RIGHT);
        } else {
            return;
        }

        if (game.getState() == SnakeGame.GameState.WAITING) {
            game.setState(SnakeGame.GameState.STARTED);
        }
    }
}
