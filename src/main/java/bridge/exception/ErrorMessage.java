package bridge.exception;

public class ErrorMessage {

    public static final String ERROR = "[ERROR] ";

    public static final String BRIDGE_LENGTH_IS_BETWEEN_3_AND_20 = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String UP_DOWN = "위: U, 아래: D 두 가지만 입력해주세요.";
    public static final String RESTART_QUIT = "재시도: R, 종료: Q 두 가지만 입력해주세요.";
    public static final String INVALID_BRIDGE_STATUS = "다리의 상태가 올바르지 않습니다.";

    private ErrorMessage() {
    }

}
