package bridge.validator;

import bridge.exception.UserInputException;

public class InputViewValidator {

    private static final int ASCII_ZERO = 48;
    private static final int ASCII_NINE = 57;
    private static final int ASCII_UPPER_A = 65;
    private static final int ASCII_UPPER_Z = 90;
    private static final int ASCII_UPPER_U = 85;
    private static final int ASCII_UPPER_D = 68;
    private static final int ASCII_UPPER_R = 82;
    private static final int ASCII_UPPER_Q = 81;
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final int COMMAND_SIZE = 1;
    private static final int INDEX_ZERO = 0;

    public static void checkBridgeSizeIsNotNumber(final String userInput) {
        for (int i = INDEX_ZERO; i < userInput.length(); ++i) {
            final char checkNumber = userInput.charAt(i);
            if (checkNumber < ASCII_ZERO || ASCII_NINE < checkNumber) {
                UserInputException.isNotNumber();
            }
        }
    }

    public static void checkBridgeSizeNotInvalid(final int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || BRIDGE_MAX_SIZE < bridgeSize) {
            UserInputException.invalidBridgeSize();
        }
    }

    public static void checkCommandSize(final String command) {
        if (command.length() != COMMAND_SIZE) {
            UserInputException.invalidCommandSize();
        }
    }

    public static void checkCommandUpperCase(final String userInput) {
        for (int i = INDEX_ZERO; i < userInput.length(); ++i) {
            final char check = userInput.charAt(i);
            if (check < ASCII_UPPER_A || ASCII_UPPER_Z < check) {
                UserInputException.isNotUpperCaseCharacter();
            }
        }
    }

    public static void checkMovingCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_U && checkCommand != ASCII_UPPER_D) {
            UserInputException.invalidMovingCommandCharacter();
        }
    }

    public static void checkRetryCommandCharacter(final String command) {
        final char checkCommand = command.charAt(INDEX_ZERO);
        if (checkCommand != ASCII_UPPER_R && checkCommand != ASCII_UPPER_Q) {
            UserInputException.invalidRetryCommandCharacter();
        }
    }
}
