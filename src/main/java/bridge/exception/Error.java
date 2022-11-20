package bridge.exception;

public enum Error {
    NOT_INT("숫자를 입력하세요."),
    WRONG_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String ERROR = "[ERROR]";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }

}
