package game;

public enum Direction {
    UP(DirectionAxis.VERTICAL),
    DOWN(DirectionAxis.VERTICAL),
    LEFT(DirectionAxis.HORIZONTAL),
    RIGHT(DirectionAxis.HORIZONTAL);

    private DirectionAxis axis;

    Direction(DirectionAxis axis) {
        this.axis = axis;
    }

    public DirectionAxis getAxis() {
        return axis;
    }
}
