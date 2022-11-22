package bridge.commom.constant;

public class GameCommand {

    public static final String DOWN_COMMAND = "D";
    public static final String UPPER_COMMAND = "U";
    public static final String RESTART_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";

    public static boolean isUpperCommand(String input) {
        return input.equals(UPPER_COMMAND);
    }

    public static boolean isDownCommand(String input) {
        return input.equals(DOWN_COMMAND);
    }

    public static boolean isRestartCommand(String input) {
        return input.equals(RESTART_COMMAND);
    }

    public static boolean isQuitCommand(String input) {
        return input.equals(QUIT_COMMAND);
    }
}
