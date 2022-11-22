package bridge.Constant;

public enum Error {

    NUMBER("[ERROR] 숫자만 입력해주세요."),
    THREE_TO_TWENTY("[ERROR] 3~20 사이의 숫자만 입력해주세요"),
    MOVE("[ERROR] U, D만 입력해주세요."),
    RESTART("[ERROR] R, Q만 입력해주세요.");

    private final String error;

    Error(final String error) {
        this.error = error;
    }

    public String printError() {
        return error;
    }
}
