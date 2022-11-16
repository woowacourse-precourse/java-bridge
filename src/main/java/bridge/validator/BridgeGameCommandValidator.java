package bridge.validator;

import bridge.exception.BridgeGameCommandException;
import bridge.exception.UserInputException;

public class BridgeGameCommandValidator {

    private static final int ASCII_UPPER_A = 65;
    private static final int ASCII_UPPER_Z = 90;
    private static final int ASCII_UPPER_U = 85;
    private static final int ASCII_UPPER_D = 68;
    private static final int ASCII_UPPER_R = 82;
    private static final int ASCII_UPPER_Q = 81;
    private static final int COMMAND_SIZE = 1;
    private static final int INDEX_ZERO = 0;

    public static String movingCommandValidation(final String command) {
        checkCommandSize(command);
        checkCommandUpperCase(command);
        checkMovingCommandCharacter(command);
        return command;
    }

    public static String retryCommandValidation(final String command) {
        checkCommandSize(command);
        checkCommandUpperCase(command);
        checkRetryCommandCharacter(command);
        return command;
    }

    private static void checkCommandSize(final String command) {
        if (command.length() != COMMAND_SIZE) {
            BridgeGameCommandException.invalidCommandSize();
        }
    }

    private static void checkCommandUpperCase(final String userInput) {
        for (int i = INDEX_ZERO; i < userInput.length(); ++i) {
            final char check = userInput.charAt(i);
            if (check < ASCII_UPPER_A || ASCII_UPPER_Z < check) {
                BridgeGameCommandException.isNotUpperCaseCharacter();
            }
        }
    }

    private static void checkMovingCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_U && checkCommand != ASCII_UPPER_D) {
            BridgeGameCommandException.invalidMovingCommandCharacter();
        }
    }

    private static void checkRetryCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_R && checkCommand != ASCII_UPPER_Q) {
            BridgeGameCommandException.invalidRetryCommandCharacter();
        }
    }
}
