package bridge.util;

public class ExceptionHandler {

    static final int BRIDGE_LENGTH_MIN = 3;
    static final int BRIDGE_LENGTH_MAX = 20;

    public static void checkBridgeLength(String input) throws IllegalArgumentException {
        int bridgeLength = Integer.parseInt(input);
        if (!isValidRange(bridgeLength)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidRange(int bridgeLength) {
        return (BRIDGE_LENGTH_MIN <= bridgeLength && bridgeLength <= BRIDGE_LENGTH_MAX);
    }
}
