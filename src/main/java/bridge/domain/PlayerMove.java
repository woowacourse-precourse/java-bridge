package bridge.domain;

public class PlayerMove {

    private final MoveResult moveResult;
    private final Direction direction;

    public PlayerMove(MoveResult moveResult, Direction direction) {
        this.moveResult = moveResult;
        this.direction = direction;
    }

    public boolean isNotSameDirection(Direction direction) {
        return this.direction.isNotSameDirection(direction);
    }

    public boolean isFail() {
        return moveResult.isFail();
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
