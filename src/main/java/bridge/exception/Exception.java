package bridge.exception;

public enum Exception {
    RANGE_EXCEPTION(new IllegalArgumentException("[ERROR] " + "3 ~ 20 사이의 수를 입력해주세요"));
    private IllegalArgumentException exception;

    Exception(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}
