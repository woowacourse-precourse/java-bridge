package bridge.validator;

import bridge.exception.UserInputException;

public class UserInputValidator {

    private static final int ASCII_ZERO = 48;
    private static final int ASCII_NINE = 57;
    private static final int INDEX_ZERO = 0;
    private static final int SIZE_ZERO = 0;
    private static final int ASCII_UPPER_A = 65;
    private static final int ASCII_UPPER_Z = 90;
    private static final int ASCII_UPPER_U = 85;
    private static final int ASCII_UPPER_D = 68;
    private static final int ASCII_UPPER_R = 82;
    private static final int ASCII_UPPER_Q = 81;
    private static final int COMMAND_SIZE = 1;

    public static String ckeckBridgeSize(final String userInput) {
        checkBridgeSizeIsNotZero(userInput);
        checkBridgeSizeIsNotNumber(userInput);
        return userInput;
    }

    public static String movingGameCommandValidation(final String command) {
        checkGameCommandSize(command);
        checkUpperCase(command);
        checkMovingCommandCharacter(command);
        return command;
    }

    public static String retryGameCommandValidation(final String command) {
        checkGameCommandSize(command);
        checkUpperCase(command);
        checkRetryGameCommandCharacter(command);
        return command;
    }

    private static void checkGameCommandSize(final String command) {
        if (command.length() != COMMAND_SIZE) {
            UserInputException.invalidCommandSize();
        }
    }

    private static void checkBridgeSizeIsNotNumber(final String userInput) {
        for (int i = INDEX_ZERO; i < userInput.length(); ++i) {
            final char checkNumber = userInput.charAt(i);
            if (checkNumber < ASCII_ZERO || ASCII_NINE < checkNumber) {
                UserInputException.isNotPositiveNumber();
            }
        }
    }

    private static void checkBridgeSizeIsNotZero(final String userInput) {
        if (userInput.length() == SIZE_ZERO) {
            UserInputException.sizeZero();
        }
    }

    private static void checkUpperCase(final String userInput) {
        for (int i = INDEX_ZERO; i < userInput.length(); ++i) {
            final char check = userInput.charAt(i);
            if (check < ASCII_UPPER_A || ASCII_UPPER_Z < check) {
                UserInputException.isNotUpperCaseCharacter();
            }
        }
    }

    private static void checkMovingCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_U && checkCommand != ASCII_UPPER_D) {
            UserInputException.invalidMovingCommandCharacter();
        }
    }

    private static void checkRetryGameCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_R && checkCommand != ASCII_UPPER_Q) {
            UserInputException.invalidRetryCommandCharacter();
        }
    }


}
