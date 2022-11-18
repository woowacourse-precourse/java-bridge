package bridge.util;

import bridge.model.constant.Message;
import bridge.view.OutputView;

public class ExceptionHandler {

    static final int BRIDGE_SIZE_MIN = 3;
    static final int BRIDGE_SIZE_MAX = 20;
    static final String RE_START = "R";
    static final String QUIT = "Q";

    public static void checkBridgeSize(final String input) {
        try {
            int size = Integer.parseInt(input);
            isValidRange(size);
        } catch (IllegalArgumentException illegalArgumentException) {
            String message = Message.ERROR_PREFIX + Message.ERROR_BRIDGE_SIZE;
            throw new IllegalArgumentException(message);
        }
    }

    private static void isValidRange(final int size) throws IllegalArgumentException {
        if (!(BRIDGE_SIZE_MIN <= size && size <= BRIDGE_SIZE_MAX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkMoving(final String input) {
        if (!isValidMoving(input)) {
            String message = Message.ERROR_PREFIX + Message.ERROR_MOVING;
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean isValidMoving(final String input) {
        if (input.equals(Message.UP) || input.equals(Message.DOWN)) {
            return true;
        }
        return false;
    }

    public static void checkRetryCommand(final String input) throws IllegalArgumentException {
        if (!(input.equals(RE_START) || input.equals(QUIT))) {
            String message = Message.ERROR_PREFIX + Message.ERROR_RETRY;
            throw new IllegalArgumentException(message);
        }
    }
}
