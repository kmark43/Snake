package game;

public class SnakePiece {
    private BoardPos boardPos;

    public SnakePiece(BoardPos boardPos) {
        this.boardPos = boardPos;
    }

    public BoardPos getBoardPos() {
        return boardPos;
    }

    public void setBoardPos(BoardPos boardPos) {
        this.boardPos = boardPos;
    }
}
