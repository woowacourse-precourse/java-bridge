package bridge.validator;

import bridge.exception.UserInputException;

public class UserInputValidator {

    private static final int INDEX_ZERO = 0;
    private static final int SIZE_ZERO = 0;
    private static final int ASCII_UPPER_A = 65;
    private static final int ASCII_UPPER_Z = 90;
    private static final int COMMAND_SIZE = 1;

    public static int checkBridgeSize(final String userInput) {
        checkUserInputIsNotZero(userInput);
        if (!checkIsNumber(userInput)) {
            UserInputException.isNotNumber();
        }
        return Integer.parseInt(userInput);
    }

    public static String gameCommandValidation(final String command) {
        checkGameCommandSize(command);
        checkUpperCase(command);
        return command;
    }

    private static void checkGameCommandSize(final String command) {
        if (command.length() != COMMAND_SIZE) {
            UserInputException.invalidCommandSize();
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

    private static void checkUserInputIsNotZero(final String userInput) {
        if (userInput.length() == SIZE_ZERO) {
            UserInputException.sizeZero();
        }
    }

    private static boolean checkIsNumber(final String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
