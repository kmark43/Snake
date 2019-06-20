package game;

import java.util.Iterator;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Direction> directionQueue;
    private Direction movementDirection;
    private LinkedList<SnakePiece> snakePieces;
    private int numPiecesToAdd;

    public Snake(int x, int y) {
        directionQueue = new LinkedList<>();
        snakePieces = new LinkedList<>();
        snakePieces.addFirst(new SnakePiece(new BoardPos(x, y)));
    }

    public SnakePiece getHead() {
        return snakePieces.getFirst();
    }

    public void queueDirection(Direction direction) {
        if (directionQueue.size() == 2) {
            directionQueue.removeLast();
        }
        if (movementDirection == null ||
                getLastDirection().getAxis() != direction.getAxis()) {
            directionQueue.addLast(direction);
        }
    }

    private Direction getLastDirection() {
        if (directionQueue.isEmpty()) {
            return movementDirection;
        } else {
            return directionQueue.getLast();
        }
    }

    public Direction getDirection() {
        return movementDirection;
    }

    public void addLength(int length) {
        numPiecesToAdd += length;
    }

    public void update() {
        if (!directionQueue.isEmpty()) {
            movementDirection = directionQueue.poll();
        }
        SnakePiece head = snakePieces.getFirst();
        Iterator<SnakePiece> pieceIterator = snakePieces.iterator();
        BoardPos lastPos = pieceIterator.next().getBoardPos();
        while (pieceIterator.hasNext()) {
            SnakePiece current = pieceIterator.next();
            BoardPos pos = current.getBoardPos();
            current.setBoardPos(lastPos);
            lastPos = pos;
        }
        if (numPiecesToAdd > 0) {
            numPiecesToAdd--;
            snakePieces.addLast(new SnakePiece(lastPos));
        }
        switch (movementDirection) {
            case UP:
                head.setBoardPos(new BoardPos(head.getBoardPos().getX(),
                        head.getBoardPos().getY() - 1));
                break;
            case DOWN:
                head.setBoardPos(new BoardPos(head.getBoardPos().getX(),
                        head.getBoardPos().getY() + 1));
                break;
            case LEFT:
                head.setBoardPos(new BoardPos(head.getBoardPos().getX() - 1,
                        head.getBoardPos().getY()));
                break;
            case RIGHT:
                head.setBoardPos(new BoardPos(head.getBoardPos().getX() + 1,
                        head.getBoardPos().getY()));
                break;
        }
    }

    public int getLength() {
        return snakePieces.size() + numPiecesToAdd;
    }

    public LinkedList<SnakePiece> getSnakePieces() {
        return snakePieces;
    }
}
