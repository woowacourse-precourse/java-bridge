package bridge.Utils;

public enum ExceptionType {

    IS_NOT_NUMBER("입력한 값이 숫자가 아닙니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
