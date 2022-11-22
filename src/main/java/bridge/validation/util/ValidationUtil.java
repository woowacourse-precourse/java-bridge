package bridge.validation.util;

public class ValidationUtil {

    public static boolean isInteger(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isWithinValidRange(String bridgeSize) {
        int input = Integer.parseInt(bridgeSize);

        return 3 <= input && input <= 20;
    }

    public static boolean isOneCharacter(String input) {
        return input.length() == 1;
    }

    public static boolean isValidMoving(String moving) {
        return moving.equals("U") || moving.equals("D");
    }

    public static boolean isValidGameCommand(String gameCommand) {
        return gameCommand.equals("R") || gameCommand.equals("Q");
    }
}
