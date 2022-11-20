package bridge.exception;

public enum Error {
    NOT_INT("숫자를 입력하세요.");

    private final String ERROR = "[ERROR]";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }

}
