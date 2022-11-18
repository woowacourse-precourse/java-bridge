package bridge;

public class ErrorCode {
    private static final String LEADING_CODE = "[ERROR] ";

    public static final String WRONG_BRIDGE_LENGTH_INPUT = LEADING_CODE + "다리 길이는 3 부터 20 사이의 숫자여야 합니다.";
    public static final String WRONG_MOVE_INPUT = LEADING_CODE + "이동은 U 혹은 D 여야 합니다.";
}
