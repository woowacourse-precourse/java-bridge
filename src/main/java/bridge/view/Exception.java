package bridge.view;

public class Exception {
    private static final int MIX_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static boolean isNumeric(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean checkBridgeSize(int size) {
        return size >= MIX_SIZE && size <= MAX_SIZE;
    }

    public static boolean checkMoving(String input) {
        return input.equals(UP) || input.equals(DOWN);
    }

    public static boolean checkRetry(String input) {
        return input.equals(RETRY) || input.equals(QUIT);
    }
}
