package bridge.constant;

public class BridgeGameConstant {

    public static final int UP_BRIDGE_BLOCK_NUMBER = 1;
    public static final int DOWN_BRIDGE_BLOCK_NUMBER = 0;
    public static final String UP_BRIDGE_BLOCK = "U";
    public static final String DOWN_BRIDGE_BLOCK = "D";
    public static final String RETRY_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";
    public static final int BRIDGE_SIZE_MIN = 3;
    public static final int BRIDGE_SIZE_MAX = 20;

    public static final class ExceptionMessage {
        public static final String PREFIX = "[ERROR] ";
        public static final String INVALID_BRIDGE_SIZE_ONLY_INTEGER = PREFIX + "다리 길이는 정수이어야 합니다.";
        public static final String INVALID_BRIDGE_SIZE_RANGE = PREFIX + "다리 길이는 " + BRIDGE_SIZE_MIN + "부터 " + BRIDGE_SIZE_MAX + " 사이의 값이어야 합니다.";
        public static final String INVALID_MOVING = PREFIX + "이동할 칸은 " + UP_BRIDGE_BLOCK + " 또는 " + DOWN_BRIDGE_BLOCK + " 이어야 합니다.";
        public static final String INVALID_GAME_COMMAND = PREFIX + "게임 재시도 여부는 " + RETRY_COMMAND + " 또는 " + QUIT_COMMAND + " 이어야 합니다.";
    }
}
