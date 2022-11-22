package bridge.utils;

public class Constants {
    public static final int DOWN_NUMBER = 0;
    public static final int UP_NUMBER = 1;
    public static final String DOWN_BLOCK = "D";
    public static final String UP_BLOCK = "U";
    public static final String PLAYER_RETRY = "R";
    public static final String PLAYER_QUIT = "Q";
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;

    public static final boolean IS_UP_BLOCK = true;
    public static final boolean IS_DOWN_BLOCK = true;
    public static final boolean IS_FAILURE = true;
    public static final boolean IS_NOT_FAILURE = false;
    public static final String BLOCK_SUCCESS = " O ";
    public static final String BLOCK_FAILURE = " O ";
    public static final String BLOCK_BLANK = " O ";
    public static final String BLOCK_SPLIT = "|";
    public static final String LINE_START = "[";
    public static final String LINE_END = "]";

    public static final String ERROR_BRIDGE_SIZE_NOT_INTEGER = "[ERROR] 다리 길이는 숫자여야 합니다";
    public static final String ERROR_BRIDGE_SIZE_NOT_IN_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ERROR_BRIDGE_SIZE_IS_ZERO = "[ERROR] 다리 길이는 0이 아닌 숫자여야 합니다.";
}
