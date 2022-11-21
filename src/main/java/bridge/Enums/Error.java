package bridge.Enums;

public enum Error {

    SIZE_INTEGER_ERROR("[ERROR] 다리 길이는 숫자여야 합니다."),
    SIZE_RANGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_U_OR_D("[ERROR] U 또는 D만 가능합니다.(소문자도 가능)"),
    NOT_R_OR_Q("[ERROR] R 또는 Q만 가능합니다.(소문자도 가능)");

    private final String message;
    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
