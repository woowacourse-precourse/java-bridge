package bridge.validation.enums;

public enum ErrorMessage {
    NULL_EXCEPTION("[ERROR] 빈 문자열이 입력되었습니다. 3부터 20사이의 숫자를 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}