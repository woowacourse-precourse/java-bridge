package bridge.dto;

import bridge.constant.Direction;

public class TrialResult {

    private final Direction direction;
    private final boolean wasSuccessful;

    public TrialResult(Direction direction, boolean wasSuccessful) {
        this.direction = direction;
        this.wasSuccessful = wasSuccessful;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean wasSuccessful() {
        return wasSuccessful;
    }
}
