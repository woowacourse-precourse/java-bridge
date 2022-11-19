package bridge.config;

public enum BaseException {
    INVALID_INPUT("[ERROR] : 유효하지 않은 입력입니다.");

    private String message;

    private BaseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
