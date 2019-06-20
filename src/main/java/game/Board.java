package game;

public class Board {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    private Tile[][] board;

    public Board() {
        board = new Tile[HEIGHT][WIDTH];
        clear();
    }

    public void clear() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = Tile.AIR;
            }
        }
    }

    public void setTile(BoardPos pos, Tile tile) {
        board[pos.getY()][pos.getX()] = tile;
    }

    public Tile getTile(BoardPos pos) {
        return board[pos.getY()][pos.getX()];
    }
}
