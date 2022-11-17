package bridge.validator;

public enum ExceptionMessage {
    BLANK("값을 입력해주세요."),
    NO_NUMBER("숫자만 입력할 수 있습니다."),
    OVER_OR_UNDER_RANGE("3 ~ 30 사이의 숫자만 입력할 수 있습니다."),
    UP_DOWN("U 또는 D 값만 입력할 수 있습니다."),
    RESTART_WHETHER("R 또는 Q 값만 입력할 수 있습니다.");

    private String message;
    private static final String PREFIX = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
