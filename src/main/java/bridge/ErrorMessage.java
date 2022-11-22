package bridge;

public final class ErrorMessage {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static final String INVALID_BRIDGE_SIZE
        = ERROR_MESSAGE_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static final String INVALID_BRIDGE_SIZE_FORMAT
        = ERROR_MESSAGE_PREFIX + "다리의 길이는 숫자만 입력 가능합니다.";

    public static final String INVALID_DIRECTION
        = ERROR_MESSAGE_PREFIX + "이동할 칸은 U 또는 D만 입력 가능합니다.";

    public static final String INVALID_GAME_COMMEND
        = ERROR_MESSAGE_PREFIX + "게임 재시작/종료 여부는 R 또는 Q만 입력 가능합니다.";
}
