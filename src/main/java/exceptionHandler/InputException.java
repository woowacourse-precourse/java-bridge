package exceptionHandler;

import enumCollections.AvailableInput;
import enumCollections.ExceptionMessage;
import enumCollections.Side;

public class InputException {
    private static final String regularExpression = "^[0-9]*$";

    public static void validateGameCommand(String gameCommand) {
        if (!AvailableInput.isGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.RESTART));
        }
    }

    public static void validateSideSelection(String side) {
        if (!Side.isBridgeSavingFormat(side)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.SELECT_SIDE));
        }
    }

    protected static void validateCharactersOnly(String value) {
        if (value.matches(regularExpression)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.NOT_CHARACTER));
        }
    }

    protected static void validateNumbersOnly(String value) {
        if (!value.matches(regularExpression)) {
            throw new IllegalArgumentException(ExceptionMessage.getMessage(ExceptionMessage.NOT_NUMERIC));
        }
    }
}
