package bridge;

import static bridge.ErrorType.*;
import static bridge.ValueType.BRIDGE_SIZE_END;
import static bridge.ValueType.BRIDGE_SIZE_START;

public class InputValidation {

    public int readBridgeSizeValidation(String bridgeSize) {
        int size = getNumberToBridgeSize(bridgeSize);

        if (size < BRIDGE_SIZE_START.getValue() || size > BRIDGE_SIZE_END.getValue()) {
            throw new IllegalArgumentException(String.format(NOT_BRIDGE_SIZE.getMessage(),
                    BRIDGE_SIZE_START.getValue(), BRIDGE_SIZE_END.getValue()));
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
