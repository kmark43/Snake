package game;

public class SnakeGame {
    public static final int FOOD_POINTS = 200;
    public static final int MAX_BONUS = 200;
    public static final int BONUS_LOSS_RATE = 1;
    public static final int GAME_END_COOLDOWN = 200;

    private Board board;
    private Snake snake;
    private BoardPos food;
    private int score;
    private int bonus;

    private GameState state;

    private long endStart;

    public SnakeGame() {
        this.board = new Board();
        this.snake = new Snake((int)(Math.random() * Board.WIDTH),
                (int)(Math.random() * Board.HEIGHT));
        this.score = 0;
        setState(GameState.WAITING);
    }

    public void update() {
        switch (state) {
            case WAITING:
                break;
            case STARTED:
                updateStarted();
                break;
            case ENDED:
                break;
        }
    }

    public void updateStarted() {
        snake.update();
        bonus = Math.max(0, bonus - BONUS_LOSS_RATE);
        board.clear();
        boolean gameOver = false;
        for (SnakePiece piece : snake.getSnakePieces()) {
            int x = piece.getBoardPos().getX();
            int y = piece.getBoardPos().getY();
            if (x < 0 || x >= Board.WIDTH || y < 0 || y >= Board.HEIGHT ||
                    board.getTile(piece.getBoardPos()) == Tile.SNAKE) {
                gameOver = true;
            } else {
                board.setTile(piece.getBoardPos(), Tile.SNAKE);
            }
        }

        if (board.getTile(food).equals(Tile.SNAKE)) {
            spawnFoodPoint();
            snake.addLength(4);
            score += FOOD_POINTS + bonus;
            bonus = MAX_BONUS;
        } else {
            board.setTile(food, Tile.FOOD);
        }

        if (gameOver) {
            setState(GameState.ENDED);
        }
    }

    public Board getBoard() {
        return board;
    }

    public Snake getSnake() {
        return snake;
    }

    public int getScore() {
        return score;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        if (this.state == GameState.ENDED &&
                System.currentTimeMillis() - endStart < GAME_END_COOLDOWN) {
            return;
        }

        this.state = state;
        switch (state) {
            case WAITING:
                score = 0;
                bonus = MAX_BONUS;
                snake = new Snake((int)(Math.random() * Board.WIDTH),
                        (int)(Math.random() * Board.HEIGHT));
                board.clear();
                board.setTile(snake.getHead().getBoardPos(), Tile.SNAKE);
                spawnFoodPoint();
                break;
            case STARTED:
                break;
            case ENDED:
                endStart = System.currentTimeMillis();
                break;
        }
    }

    private void spawnFoodPoint() {
        do {
            food = new BoardPos((int)(Math.random() * Board.WIDTH),
                    (int)(Math.random() * Board.HEIGHT));
        } while (board.getTile(food) == Tile.SNAKE);
        board.setTile(food, Tile.FOOD);
    }

    public enum GameState {
        WAITING,
        STARTED,
        ENDED
    }
}
