package exceptionHandler;

import enumCollections.ExceptionMessage;

public class InputException {
    public static void validateRestartInput(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.RESTART));
        }
    }
}
