package bridge.Controller;

import static bridge.Constant.ErrorMessage.*;
import static bridge.Constant.InputValue.*;

public class InputValidator {



    public static void validateNumberInput(String input) throws IllegalArgumentException {
        final String NOT_NUMBER_REGEX = "[^0-9]";

        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }

        if (input.matches(NOT_NUMBER_REGEX)) {
            throw new IllegalArgumentException(WRONG_SIZE_INPUT);
        }
    }

    public static void validateSelectionInput(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }

        if (!input.equals(SELECTION_UP) && !input.equals(SELECTION_DOWN)) {
            throw new IllegalArgumentException(WRONG_SELECTION_INPUT);
        }
    }

    public static void validateCommandInput(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }

        if (!input.equals(COMMAND_RETRY) && !input.equals(COMMAND_QUIT)) {
            throw new IllegalArgumentException(WRONG_COMMAND_INPUT);
        }
    }

}
