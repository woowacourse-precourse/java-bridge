package bridge.util;

import bridge.model.constant.Message;

public class ExceptionHandler {

    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;

    public void checkBridgeSize(final String input) {
        try {
            int size = Integer.parseInt(input);
            isValidRange(size);
        } catch (IllegalArgumentException illegalArgumentException) {
            String message = Message.ERROR_PREFIX + Message.ERROR_BRIDGE_SIZE;
            throw new IllegalArgumentException(message);
        }
    }

    private void isValidRange(final int size) {
        if (!(BRIDGE_SIZE_MIN <= size && size <= BRIDGE_SIZE_MAX)) {
            throw new IllegalArgumentException();
        }
    }

    public void checkMoving(final String input) {
        if (!isValidMoving(input)) {
            String message = Message.ERROR_PREFIX + Message.ERROR_MOVING;
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isValidMoving(final String input) {
        if (input.equals(Message.UP) || input.equals(Message.DOWN)) {
            return true;
        }
        return false;
    }

    public void checkRetryCommand(final String input) {
        if (!(input.equals(Message.RE_START) || input.equals(Message.QUIT))) {
            String message = Message.ERROR_PREFIX + Message.ERROR_RETRY;
            throw new IllegalArgumentException(message);
        }
    }
}
