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

    public static String validateMoving(String input) {
        if (!(input.equals(BridgeEnum.U.name()) || input.equals(BridgeEnum.D.name()))) {
            throw new IllegalArgumentException(BridgeError.INVALID_MOVING.getMessage());
        }
        return input;
    }

    public static String validateGameCommand(String input) {
        if (!(input.equals(GameCommandEnum.R.name()) || input.equals(GameCommandEnum.Q.name()))) {
            throw new IllegalArgumentException(BridgeError.INVALID_GAME_COMMAND.getMessage());
        }
        return input;
    }

    public static boolean isInteger(String input) {
        if (input.matches("[+-]?\\d+")) {
            return true;
        }
        return false;
    }
}
