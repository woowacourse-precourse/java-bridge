package bridge;

public class BridgeVerifier {
    public static int validateBridgeSize(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(BridgeError.INVALID_BRIDGE_SIZE.getMessage());
        }
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(BridgeError.INVALID_BRIDGE_SIZE.getMessage());
        }
        return bridgeSize;
    }

    public static boolean isInteger(String input) {
        if (input.matches("[+-]?\\d+")) {
            return true;
        }
        return false;
    }
}
