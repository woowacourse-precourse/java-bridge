package bridge.service;

public class Referee {
    private static final String MOVE_COMMAND_UP = "U";
    private static final String MOVE_COMMAND_DOWN = "D";

    public int convertPath(String path) {
        if (path.equals(MOVE_COMMAND_UP)) {
            return 1;
        }
        return 0;
    }
}
