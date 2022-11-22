package bridge.domain;

import bridge.constants.ErrorCode;

public class GameRule {
    public static final int BRIDGE_LENGTH_MIN = 3;
    public static final int BRIDGE_LENGTH_MAX = 20;
    public static final String COMMAND_RETRY = "R";
    public static final String COMMAND_QUIT = "Q";

    public static int getBridgeSize(int size) {
        validateBridgeSize(size);
        return size;
    }

    public static String getPlayerMoving(String input) {
        validateMovingInput(input);
        return input;
    }

    public static String getCommand(String command) {
        validateCommand(command);
        return command;
    }

    public static void validateBridgeSize(int size) {
        if (BRIDGE_LENGTH_MAX < size || size < BRIDGE_LENGTH_MIN) {

            ErrorCode.ERROR_INVALID_BRIDGE_SIZE.throwIllegalArgumentException();
        }
    }

    public static void validateMovingInput(String input) {
        for (Bridge bridge : Bridge.values()) {
            if (input.equals(bridge.getSymbol())) {
                return;
            }
        }
        ErrorCode.ERROR_INVALID_BRIDGE_TO_MOVE.throwIllegalArgumentException();
    }

    public static void validateCommand(String input) {
        if (!input.equals(COMMAND_RETRY) && !input.equals(COMMAND_QUIT)) {
            ErrorCode.ERROR_INVALID_COMMAND.throwIllegalArgumentException();
        }
    }

}
