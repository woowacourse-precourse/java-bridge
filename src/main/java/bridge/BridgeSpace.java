package bridge;

import static bridge.util.ErrorMessage.BRIDGE_RANDOM_NUMBER_ERROR_MESSAGE;
import static bridge.util.ErrorMessage.ERROR_MESSAGE;

public enum BridgeSpace {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String direction;

    BridgeSpace(int number, String direction) {
        this.number = number;
        this.direction = direction;
    }

    public static String get(int number) {
        if (number == DOWN.number) {
            return DOWN.getDirection();
        }
        if (number == UP.number) {
            return UP.getDirection();
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_RANDOM_NUMBER_ERROR_MESSAGE);
    }

    public String getDirection() {
        return direction;
    }
}
