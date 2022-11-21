package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;

public class InputException {

    public static void validateGameCommand(String input) {
        if (!AvailableInput.isGameCommand(input)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.RESTART));
        }
    }
}
