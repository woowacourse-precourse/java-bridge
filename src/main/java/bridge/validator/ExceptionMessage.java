package bridge.validator;

public enum ExceptionMessage {
    NO_BLANK_MESSAGE("값을 입력해주세요."),
    NO_NUMBER_MESSAGE("숫자만 입력할 수 있습니다."),
    OVER_OR_UNDER_RANGE_MESSAGE("3 ~ 20 사이의 숫자만 입력할 수 있습니다."),
    ONLY_UP_DOWN_MESSAGE("U 또는 D 값만 입력할 수 있습니다."),
    ONLY_RESTART_WHETHER_MESSAGE("R 또는 Q 값만 입력할 수 있습니다.");

    private final String message;
    private static final String PREFIX = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
