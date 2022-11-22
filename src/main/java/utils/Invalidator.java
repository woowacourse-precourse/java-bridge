package utils;

import bridge.Direction;
import exception.UserInputException;
import game.Restart;

public class Invalidator {

    public static int isValidBridgeLength(String inputValue) throws UserInputException {
        if (!isNumeric(inputValue)) {
            throw new UserInputException(ErrorMessage.ERROR_DATAFORMAT.getMessage());
        }
        if (!(Integer.parseInt(inputValue) >= 3 && Integer.parseInt(inputValue) <= 20)) {
            throw new UserInputException(ErrorMessage.ERROR_RANGE.getMessage());
        }
        return Integer.parseInt(inputValue);
    }

    public static String isValidRestartValue(String inputValue) throws UserInputException {
        if (!inputValue.equals(Restart.RESTART.getRestartMessage()) && !inputValue.equals(Restart.END.getRestartMessage())) {
            throw new UserInputException(ErrorMessage.ERROR_WRONG_VALUE.getMessage());
        }
        return inputValue;
    }

    public static String isValidMoveValue(String inputValue) throws UserInputException {
        if (!inputValue.equals(Direction.UP.getFloor()) && !inputValue.equals(Direction.DOWN.getFloor())) {
            throw new UserInputException(ErrorMessage.ERROR_WRONG_VALUE.getMessage());
        }
        return inputValue;
    }

    private static boolean isNumeric(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
