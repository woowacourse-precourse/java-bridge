package bridge.exception;

public enum ExceptionCode {
    SIZE_ERROR("[ERROR] 다리의 길이는 3이상 20이하의 숫자입니다.");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
