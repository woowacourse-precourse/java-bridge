package bridge.domain;

import bridge.exception.BridgeError;
import bridge.exception.ErrorException;

import java.util.Arrays;

public enum Direction {
    MOVING_UP("U", 1),
    MOVING_DOWN("D", 0);

    private final String movingDirection;
    private final int movingNumber;

    Direction(String movingDirection, int movingNumber) {
        this.movingDirection = movingDirection;
        this.movingNumber = movingNumber;
    }

    public static Direction findDirectionByNumber(int number) {
        return Arrays.stream(values())
                .filter(direction -> direction.movingNumber == number)
                .findAny()
                .orElseThrow(() -> new ErrorException(BridgeError.INVALID_DIRECTION));
    }

    public String getMovingDirection() {
        return movingDirection;
    }

    public int getMovingNumber() {
        return movingNumber;
    }
}
