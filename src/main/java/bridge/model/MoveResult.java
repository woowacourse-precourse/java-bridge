package bridge.model;

public class MoveResult {
    private final DrawType drawType;
    private final Direction direction;

    public MoveResult(DrawType drawType, Direction direction) {
        this.drawType = drawType;
        this.direction = direction;
    }

    public DrawType getDrawType() {
        return drawType;
    }

    public boolean compareDrawType(DrawType otherDrawType) {
        return drawType == otherDrawType;
    }

    public boolean compareDirection(Direction otherDirection) {
        return direction == otherDirection;
    }
}
