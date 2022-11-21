package bridge.constant;

public class ErrorCode {

    private static final String LEADING_CODE = "[ERROR] ";
    public static final String WRONG_BRIDGE_SIZE_INPUT = LEADING_CODE + "다리 길이는 3 부터 20 사이의 숫자여야 합니다.";
    public static final String WRONG_MOVE_INPUT = LEADING_CODE + "이동은 U 혹은 D 여야 합니다.";
    public static final String WRONG_GAME_COMMAND_INPUT = LEADING_CODE + "게임 재시도 여부는 R 혹은 Q 여야 합니다.";
}
