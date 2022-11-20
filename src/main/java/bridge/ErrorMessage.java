package bridge;

public enum ErrorMessage {
    ERROR_MESSAGE_INPUT_INCLUDE_CHARACTER("[ERROR] 입력에 문자가 포함되어 있습니다."),
    ERROR_MESSAGE_INPUT_NOT_BETWEEN_MIN_AND_MAX("[ERROR] 입력 가능한 범위는 3 이상 20이하입니다."),
    ERROR_MESSAGE_INPUT_UP_OR_DOWN("[ERROR] 이동은 U 또는 D만 입력 가능합니다."),
    ERROR_MESSAGE_INPUT_RESTART_OR_QUIT("[ERROR] 재시작 및 종료는 R 또는 Q만 입력 가능합니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
