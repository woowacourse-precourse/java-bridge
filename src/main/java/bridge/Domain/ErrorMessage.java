package bridge.Domain;

public enum ErrorMessage {
    INVALID_CANT_CONVERT_INTEGER("[ERROR] 숫자가 아닙니다."),
    INVALID_RANGE("[ERROR] 3 이상 20 이하 숫자를 입력해주세요."),
    INVALID_VALUE("[ERROR] 올바른 값을 입력해주세요.");

    private final String ErrorMessage;

    ErrorMessage(String errorMessage) {
        this.ErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }
}
