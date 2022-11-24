package bridge.view;

import bridge.messages.ErrorMessage;
import bridge.messages.Message;

public class InputDirectionValidator {
    private static final int ZERO = 0;
    private static final char CHAR_ZERO = '0';
    private static final char CHAR_NINE = '9';

    public static void validateInputDirectionException(String inputDirection) {
        validateInputDirectionNull(inputDirection);
        validateInputNumber(inputDirection);
        validateInputDirectionLowerCase(inputDirection);
        validateInputDirection(inputDirection);
    }

    private static void validateInputDirection(String inputDirection) {
        if (!inputDirection.equals(Message.UP.getMessage()) && !inputDirection.equals(Message.Down.getMessage())) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_MOVE_INPUT.getErrorMessage());
        }
    }

    private static void validateInputDirectionLowerCase(String inputDirection) {
        char check = inputDirection.charAt(ZERO);
        if (!Character.isUpperCase(check)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
        }
    }

    private static void validateInputDirectionNull(String inputDirection) {
        if (inputDirection.length() == ZERO) {
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
