package bridge;

public class Constant {
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final String GAME_COMMAND_RETRY = "R";
    public static final String GAME_COMMAND_QUIT = "Q";
    public static final String MOVING_COMMAND_UP = "U";
    public static final String MOVING_COMMAND_DOWN = "D";
    public static final String PATTERN = "^\\d*$";
    public static final String ONLY_NUMBER_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";
    public static final String BRIDGE_SIZE_OUT_OF_RANGE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVING_COMMAND_ONLY_U_OR_D = "[ERROR] U 또는 D를 입력해 주세요.";
    public static final String GAME_COMMAND_ONLY_R_OR_Q = "[ERROR] R 또는 Q를 입력해 주세요.";
}
