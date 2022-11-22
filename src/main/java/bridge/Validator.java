package bridge;

public class Validator {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public static int validateBridgeSize(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String validateMoving(String moving) {
        if (UP.equals(moving) || DOWN.equals(moving)) {
            return moving;
        }
        throw new IllegalArgumentException();
    }

    public static String validateGameCommand(String gameCommand) {
        if (RESTART.equals(gameCommand) || QUIT.equals(gameCommand)) {
            return gameCommand;
        }
        throw new IllegalArgumentException();
    }
}
