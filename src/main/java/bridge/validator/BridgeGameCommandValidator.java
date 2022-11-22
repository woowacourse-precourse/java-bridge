package bridge.validator;

import bridge.exception.BridgeGameCommandException;

public class BridgeGameCommandValidator {

    private static final int INDEX_ZERO = 0;
    private static final int ASCII_UPPER_U = 85;
    private static final int ASCII_UPPER_D = 68;
    private static final int ASCII_UPPER_R = 82;
    private static final int ASCII_UPPER_Q = 81;
    private static final int ASCII_UPPER_A = 65;
    private static final int ASCII_UPPER_Z = 90;
    private static final int COMMAND_SIZE = 1;

    public static String checkMovingCommandCharacter(final String command) {
        checkGameCommandSize(command);
        checkUpperCase(command);
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_U && checkCommand != ASCII_UPPER_D) {
            BridgeGameCommandException.invalidMovingCommandCharacter();
        }
        return command;
    }

    public static String checkRetryGameCommandCharacter(final String command) {
        checkGameCommandSize(command);
        checkUpperCase(command);
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_R && checkCommand != ASCII_UPPER_Q) {
            BridgeGameCommandException.invalidRetryCommandCharacter();
        }
        return command;
    }

    private static void checkGameCommandSize(final String command) {
        if (command.length() != COMMAND_SIZE) {
            BridgeGameCommandException.invalidCommandSize();
        }
    }

    private static void checkUpperCase(final String userInput) {
        for (int i = INDEX_ZERO; i < userInput.length(); ++i) {
            final char check = userInput.charAt(i);
            if (check < ASCII_UPPER_A || ASCII_UPPER_Z < check) {
                BridgeGameCommandException.isNotUpperCaseCharacter();
            }
        }
    }
}
