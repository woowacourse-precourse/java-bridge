package bridge.util;

public class ExceptionHandler {

    static final int BRIDGE_SIZE_MIN = 3;
    static final int BRIDGE_SIZE_MAX = 20;

    public static void checkBridgeSize(String input) throws IllegalArgumentException {
        int size = Integer.parseInt(input);
        if (!isValidRange(size)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidRange(int size) {
        return (BRIDGE_SIZE_MIN <= size && size <= BRIDGE_SIZE_MAX);
    }
}
