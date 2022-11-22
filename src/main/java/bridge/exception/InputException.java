package bridge.exception;

import bridge.data.constant.ErrorMessage;

public class InputException {
    public static int bridgeSizeInputError(String bridgeSizeInput) throws IllegalArgumentException {
        bridgeSizeTypeError(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        bridgeSizeRangeError(bridgeSize);
        return bridgeSize;
    }

    public static void bridgeSizeTypeError(String bridgeSizeInput) {
        for (char e : bridgeSizeInput.toCharArray()) {
            if (!Character.isDigit(e)) {
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorLog());
            }
        }
    }

    public static void bridgeSizeRangeError(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorLog());
        }
    }

    public static void movingInputError(String movingInput) {
        if (!movingInput.equals("U") && !movingInput.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.MOVING_INPUT_ERROR.getErrorLog());
        }
    }

    public static void gameCommandInputError(String gameCommandInput) {
        if (!gameCommandInput.equals("R") && !gameCommandInput.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.COMMAND_INPUT_ERROR.getErrorLog());
        }
    }
}
