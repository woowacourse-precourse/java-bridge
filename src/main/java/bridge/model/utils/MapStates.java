package bridge.model.utils;

public class MapStates {

    private static final String MOVE_SUCCESS = "O";
    private static final String MOVE_FAILURE = "X";
    private static final String BLANK = " ";

    private MapStates() {
    }

    public static String moveSuccess() {
        return MOVE_SUCCESS;
    }

    public static String moveFailure() {
        return MOVE_FAILURE;
    }

    public static String blank() {
        return BLANK;
    }
}
