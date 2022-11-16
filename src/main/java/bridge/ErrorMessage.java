package bridge;

public enum ErrorMessage {
    ERROR_MESSAGE_INPUT_INCLUDE_CHARACTER("[ERROR] 입력에 문자가 포함되어 있습니다."),
    ERROR_MESSAGE_INPUT_NOT_BETWEEN_3_AND_20("[ERROR] 입력 가능한 범위는 3 이상 20이하입니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
