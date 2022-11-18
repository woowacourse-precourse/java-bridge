package bridge.util;

public class ExceptionHandler {

    static final int BRIDGE_SIZE_MIN = 3;
    static final int BRIDGE_SIZE_MAX = 20;

    public static void checkBridgeSize(final String input) throws IllegalArgumentException {
        int size = Integer.parseInt(input);
        if (!isValidRange(size)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidRange(final int size) {
        return (BRIDGE_SIZE_MIN <= size && size <= BRIDGE_SIZE_MAX);
    }

    public static void checkMoving(final String input) {
        if (!isValidMoving(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidMoving(final String input) {
        if (input.equals("U") || input.equals("D")) {
            return true;
        }
        return false;
    }

    public static void checkRetryCommand(final String input) throws IllegalArgumentException {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException();
        }
    }
}
