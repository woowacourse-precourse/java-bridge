package bridge.view;

import bridge.messages.ErrorMessage;
import bridge.messages.Message;

public class InputRestartValidator {
    private static final int ZERO = 0;
    private static final char CHAR_ZERO = '0';
    private static final char CHAR_NINE = '9';

    public static void validateInputGameRestartException(String inputRestart) {
        validateInputGameRestartNull(inputRestart);
        validateInputNumber(inputRestart);
        validateInputGameRestartLowerCase(inputRestart);
        validateInputGameRestart(inputRestart);
    }

    private static void validateInputGameRestart(String inputRestart) {
        if (!inputRestart.equals(Message.RESTART.getMessage()) && !inputRestart.equals(Message.QUIT.getMessage())) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_RESTART_INPUT.getErrorMessage());
        }
    }

    private static void validateInputGameRestartLowerCase(String inputRestart) {
        char check = inputRestart.charAt(ZERO);
        if (!Character.isUpperCase(check)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_RESTART_INPUT_LOWERCASE.getErrorMessage());
        }
    }

    private static void validateInputGameRestartNull(String inputRestart) {
        if (inputRestart.length() == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateInputNumber(String input) {
        char check = input.charAt(ZERO);
        if (check >= CHAR_ZERO && check <= CHAR_NINE) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_INPUT_NUMBER.getErrorMessage());
        }
    }
}
