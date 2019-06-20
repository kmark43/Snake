package game;

import java.util.Objects;

public class BoardPos {
    private int x;
    private int y;

    public BoardPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPos boardPos = (BoardPos) o;
        return x == boardPos.x &&
                y == boardPos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
