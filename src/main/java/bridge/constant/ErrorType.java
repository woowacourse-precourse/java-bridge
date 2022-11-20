package bridge.constant;

public enum ErrorType {
    NUMBER_ERROR("숫자를 입력해야 합니다."),
    ;

    private final String message;

    ErrorType(String message) {
        this.message = Prefix.MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }

    private static class Prefix {
        private static final String MESSAGE = "[ERROR] ";
    }
}
