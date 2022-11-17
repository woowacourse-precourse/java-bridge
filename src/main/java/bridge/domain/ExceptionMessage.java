package bridge.domain;

public class ExceptionMessage {
    public static final String NOT_NUMBER = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String NOT_IN_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String NOT_UP_OR_DOWN = "[ERROR] U(위), 혹은 D(아래)만 입력할 수 있습니다.";

    private ExceptionMessage() {
    }
}
