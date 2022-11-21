package bridge.exception;

public class IllegalArgument {

    public static boolean isNotNumber(String numberInput) {
        if (numberInput.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public static boolean isNotInBridgeSizeRange(String bridgeSizeInput) {
        if (Integer.parseInt(bridgeSizeInput) < 3 || Integer.parseInt(bridgeSizeInput) > 20) {
            return true;
        }
        return false;
    }

    public static boolean isIncorrectMoving(String moving) {
        if (moving.equals("U") || moving.equals("D")) {
            return false;
        }
        return true;
    }

    public static boolean isIncorrectGameCommand(String gameCommand) {
        if (gameCommand.equals("R") || gameCommand.equals("Q")) {
            return false;
        }
        return true;
    }
}
