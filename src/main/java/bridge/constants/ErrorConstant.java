package bridge.constants;

public enum ErrorConstant {
    SIZE_EXCEPTION("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    private String exception;

    ErrorConstant(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
