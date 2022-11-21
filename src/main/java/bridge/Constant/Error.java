package bridge.Constant;

public enum Error {
    NUMBER("[ERROR] 숫자만 입력해주세요.");

    private final String error;

    Error(final String error) {
        this.error = error;
    }

    public String printError() {
        return error;
    }
}
