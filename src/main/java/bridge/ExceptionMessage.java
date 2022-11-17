package bridge;

public enum ExceptionMessage {
    incorrectSize("올바른 값을 입력해주세요");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
