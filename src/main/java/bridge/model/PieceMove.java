package bridge.model;

import bridge.config.Direction;

public class PieceMove {

    private final Direction direction;
    private final boolean success;

    public PieceMove(final Direction direction, final boolean success) {
        this.direction = direction;
        this.success = success;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public boolean getSuccess() {
        return this.success;
    }
}
