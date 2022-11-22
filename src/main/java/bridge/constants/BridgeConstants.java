package bridge.constants;

import java.util.Map;

public abstract class BridgeConstants {
    public static final int GAME_TRY_START_COUNT = 1;
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final String UP_DIRECTION = "U";
    public static final String DOWN_DIRECTION = "D";

    public static final int NUMBER_OF_UP_DIRECTION = 1;
    public static final int NUMBER_OF_DOWN_DIRECTION = 0;

    public static final String Dividing_Line = "|";
    public static final String RESTART = "R";
    public static final String QUIT = "Q";
    public static final String RIGHT_ANSWER_IN_MAP = " O ";
    public static final String WRONG_ANSWER_IN_MAP = " X ";
    public static final String EMPTY_MAP = "   ";
    public static final int LOOP_START_COUNT = 0;
    public static final int ESCAPE_LOOP_NUM = -1;

    private BridgeConstants() {}
}
