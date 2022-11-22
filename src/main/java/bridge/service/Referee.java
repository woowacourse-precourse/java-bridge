package bridge.service;

public class Referee {
    private static final String MOVE_COMMAND_UP = "U";
    private static final String MOVE_COMMAND_DOWN = "D";
    private static final String COMPARE_PATH_EQUAL = "O";
    private static final String COMPARE_PATH_NOT_EQUAL = "X";

    public int convertPath(String path) {
        if (path.equals(MOVE_COMMAND_UP)) {
            return 1;
        }
        return 0;
    }

    public String comparePath(String movePath, String bridgePath) {
        if (movePath.equals(bridgePath)) {
            return COMPARE_PATH_EQUAL;
        }
        return COMPARE_PATH_NOT_EQUAL;
    }
}
