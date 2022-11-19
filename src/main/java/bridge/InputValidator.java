package bridge;

public class InputValidator {
    private static final int SIZE_LIMIT_START = 3;
    private static final int SIZE_LIMIT_END = 20;

    private static final String UP = "U";
    private static final String DOWN = "D";

    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static boolean isValidBridge(String bridgeSize){
        return isNumeric(bridgeSize) && isValidInRange(bridgeSize);
    }

    private static boolean isNumeric(String bridgeSize) {
        return bridgeSize.chars().allMatch(Character::isDigit);
    }

    private static boolean isValidInRange(String bridgeSize) {
        return SIZE_LIMIT_START <= Integer.parseInt(bridgeSize) && Integer.parseInt(bridgeSize) <= SIZE_LIMIT_END;
    }

    public static boolean isValidMove(String move){
        return move.matches("^[UD]$");
    }

    public static boolean isValidCmd(String cmd){
        return cmd.matches("^[RQ]$");
    }

}
