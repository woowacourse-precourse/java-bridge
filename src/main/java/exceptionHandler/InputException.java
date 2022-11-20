package exceptionHandler;

import enumCollections.ExceptionMessage;

public class InputException {
    public static void validateRestartInput(String input) {
        if (input != "R" && input != "Q") {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.RESTART));
        }
    }
}
