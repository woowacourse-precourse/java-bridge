package bridge.domain.constant;

public class ExceptionMessage {
    public static final String NULL_INPUT = "[ERROR] 다시 입력해주세요.";
    public static final String NOT_NUMBER = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String NOT_IN_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String NOT_UP_OR_DOWN = "[ERROR] U(위), 혹은 D(아래)를 입력해주세요.";
    public static final String NOT_APPROPRIATE_COMMAND = "[ERROR] R(재시도), 혹은 Q(종료)를 입력해주세요.";

    private ExceptionMessage() {
    }
}
