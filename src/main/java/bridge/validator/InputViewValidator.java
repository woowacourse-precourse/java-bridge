package bridge.validator;

import bridge.exception.UserInputException;

public class InputViewValidator {

    private static final int ASCII_ZERO = 48;
    private static final int ASCII_NINE = 57;
    private static final int INDEX_ZERO = 0;

    public static void checkBridgeSizeIsNotNumber(final String userInput) {
        for (int i = INDEX_ZERO; i < userInput.length(); ++i) {
            final char checkNumber = userInput.charAt(i);
            if (checkNumber < ASCII_ZERO || ASCII_NINE < checkNumber) {
                UserInputException.isNotNumber();
            }
        }
    }
}
