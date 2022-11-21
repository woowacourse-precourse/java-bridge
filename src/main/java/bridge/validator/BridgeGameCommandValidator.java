package bridge.validator;

import bridge.exception.BridgeGameCommandException;

public class BridgeGameCommandValidator {

    private static final int INDEX_ZERO = 0;
    private static final int ASCII_UPPER_U = 85;
    private static final int ASCII_UPPER_D = 68;
    private static final int ASCII_UPPER_R = 82;
    private static final int ASCII_UPPER_Q = 81;

    public static String checkMovingCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_U && checkCommand != ASCII_UPPER_D) {
            BridgeGameCommandException.invalidMovingCommandCharacter();
        }
        return command;
    }

    public static String checkRetryGameCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_R && checkCommand != ASCII_UPPER_Q) {
            BridgeGameCommandException.invalidRetryCommandCharacter();
        }
        return command;
    }
}
