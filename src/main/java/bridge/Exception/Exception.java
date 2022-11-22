package bridge.Exception;

import bridge.domain.DirectionType;

public class Exception {
    private static final String regExp = "^[0-9]+$";
    private static final int MIN = 3;
    private static final int MAX = 20;
    private static final String RETRY = "R";
    private static final String QUIT = "Q";


    public static void validateIsNumeric(String input) {
        ErrorMessage errorMessage = ErrorMessage.NOT_NUMERIC_VALUE;
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static void validateInterval(String input) {
        ErrorMessage errorMessage = ErrorMessage.NOT_VALID_INTERVAL_VALUE;
        if (Integer.parseInt(input) < MIN || Integer.parseInt(input) > MAX) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static void validateIsValidMoving(String input) {
        ErrorMessage errorMessage = ErrorMessage.NOT_VALID_MOVING;
        DirectionType up = DirectionType.UP;
        DirectionType down = DirectionType.DOWN;
        if (input.equals(up.getInitial()) || input.equals(down.getInitial())){
            return;
        }
        throw new IllegalArgumentException(errorMessage.getMessage());
    }

    public static void validateIsValidCommand(String input) {
        ErrorMessage errorMessage = ErrorMessage.NOT_VALID_COMMAND;
        if (input.equals(RETRY) || input.equals(QUIT)){
            return;
        }
        throw new IllegalArgumentException(errorMessage.getMessage());
    }
}
