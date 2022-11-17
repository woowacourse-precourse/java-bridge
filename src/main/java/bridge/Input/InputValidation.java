package bridge.Input;

import bridge.CommandConstant;

public class InputValidation {
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;

    public static void validateBridgeSize(String bridgeSizeInput) {
        validateInteger(bridgeSizeInput);
        validateRange(bridgeSizeInput);
    }

    private static void validateInteger(String bridgeSizeInput) {
        try {
            Integer.valueOf(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(String bridgeSizeInput) {
        int bridgeSize = Integer.valueOf(bridgeSizeInput);
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMoveCommand(String moveCommand) {
        if (!moveCommand.equals(CommandConstant.UP_COMMAND) && !moveCommand.equals(CommandConstant.DOWN_COMMAND)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(CommandConstant.RETRY_COMMAND) && !gameCommand.equals(CommandConstant.QUIT_COMMAND)) {
            throw new IllegalArgumentException();
        }
    }

}
