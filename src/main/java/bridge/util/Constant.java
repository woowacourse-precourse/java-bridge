package bridge.util;

public class Constant {

    public static final String BRIDGE_LENGTH_REGEX = "^[0-9]*$";
    public static final int BRIDGE_LENGTH_MIN = 3;
    public static final int BRIDGE_LENGTH_MAX = 20;

    public static final String ERROR_MESSAGE_BRIDGE_LENGTH_CONSIST_OF_NUM = "[ERROR] 다리 길이 입력값은 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_BRIDGE_LENGTH_RANGE_3_TO_20 = "[ERROR] 다리의 길이는 3이상 20이하여야 합니다.";
    public static final String ERROR_MESSAGE_BRIDGE_MOVE_COMMAND_INPUT_ERROR = "[ERROR] 다리 이동 입력값은 U 혹은 D이어야 합니다.";

}
