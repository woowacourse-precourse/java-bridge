package bridge.domain;

import static bridge.utils.ErrorMessages.ERROR_INVALID_MOVING;

public class BridgeMoving {
    private final Bridge bridge;

    public BridgeMoving(Bridge bridge) {
        this.bridge = bridge;
    }

    public String move(String moving, int movingIndex) {
        validateMoving(moving);
        if (isMove(moving, movingIndex)) {
            return "O";
        }
        return "X";
    }

    private boolean isMove (String moving, int movingIndex) {
        String shape = bridge.getShape(movingIndex);
        return shape.equals(moving);
    }

    private void validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(ERROR_INVALID_MOVING);
        }
    }
}
