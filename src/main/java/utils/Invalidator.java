package utils;

import bridge.Direction;
import exception.UserInputException;

public class Invalidator {

    public static int isValidBridgeLength(String inputValue) throws UserInputException {
        if (!isNumeric(inputValue)) {
            throw new UserInputException("[ERROR]");
        }
        if (!(Integer.parseInt(inputValue) >= 3 && Integer.parseInt(inputValue) <= 20)) {
            throw new UserInputException("[ERROR]");
        }
        return Integer.parseInt(inputValue);
    }

    public static String isValidMoveValue(String inputValue) throws UserInputException {
        if (!inputValue.equals(Direction.UP.getFloor()) && !inputValue.equals(Direction.DOWN.getFloor())) {
            throw new UserInputException("[ERROR]");
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
