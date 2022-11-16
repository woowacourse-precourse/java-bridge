package bridge.validator;

import bridge.exception.UserInputException;

public class InputViewValidator {

    private static final int ASCII_ZERO = 48;
    private static final int ASCII_NINE = 57;
    private static final int INDEX_ZERO = 0;
    private static final int SIZE_ZERO = 0;

    public static String ckeckBridgeSize(final String userInput) {
        checkBridgeSizeIsNotNumber(userInput);
        checkBridgeSizeIsNotZero(userInput);
        return userInput;
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
}
