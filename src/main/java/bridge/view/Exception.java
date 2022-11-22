package bridge.view;

import bridge.util.ErrorMessage;

public class Exception {
    private static final int MIX_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static void isNumeric(String input) {
        if (input == null || !input.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getMessage());
        }
    }

    public static void checkBridgeSize(int size) {
        if (size < MIX_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getMessage());
        }
    }

    public static void checkMoving(String input) {
        if (!(input.equals(UP) || input.equals(DOWN))) {
            throw new IllegalArgumentException(ErrorMessage.MOVING_ERROR.getMessage());
        }
    }

    public static void checkRetry(String input) {
        if (!(input.equals(RETRY) || input.equals(QUIT))) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_ERROR.getMessage());
        }
    }
}
