package utils;

public enum ErrorMessage {

    ERROR_HEADER("[ERROR]"),
    ERROR_DATAFORMAT(" 입력 형식이 올바르지 않습니다.."),
    ERROR_RANGE(" 입력 범위가 올바르지 않습니다."),
    ERROR_WRONG_VALUE(" 입력값이 올바르지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
