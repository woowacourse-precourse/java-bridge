package bridge;

import static bridge.ErrorType.*;

public class InputValidation {

    static final int bridgeSizeStart = 3;
    static final int bridgeSizeEnd = 20;

    public int readBridgeSizeValidation(String bridgeSize) {
        int size = getNumberToBridgeSize(bridgeSize);

        if (size < bridgeSizeStart || size > bridgeSizeEnd) {
            throw new IllegalArgumentException(String.format(NOT_BRIDGE_SIZE.getMessage(), bridgeSizeStart, bridgeSizeEnd));
        }
        return size;
    }

    private int getNumberToBridgeSize(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALUE.getMessage());
        }
    }

    public void readMovingValidation(String move) {
        if (!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException(NOT_MOVING.getMessage());
        }
    }

    public void readGameCommandValidation(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException(NOT_GAME_COMMAND.getMessage());
        }
    }
}
