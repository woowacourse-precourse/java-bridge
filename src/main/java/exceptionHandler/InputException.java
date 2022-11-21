package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;
import enumCollections.Side;

public class InputException {
    private static final String regularExpression = "^[0-9]*$";

    public static void validateGameCommand(String gameCommand) {
        if (!AvailableInput.isGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ExceptionMessage.RESTART.getMessage());
        }
    }

    public static void validateSideSelection(String side) {
        if (!Side.isBridgeSavingFormat(side)) {
            throw new IllegalArgumentException(ExceptionMessage.SELECT_SIDE.getMessage());
        }
    }

    protected static void validateCharactersOnly(String value) {
        if (value.matches(regularExpression)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_CHARACTER.getMessage());
        }
    }

    protected static void validateNumbersOnly(String value) {
        if (!value.matches(regularExpression)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
    }
}
