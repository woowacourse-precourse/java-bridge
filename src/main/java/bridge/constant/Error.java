package bridge.constant;

public enum Error {
    SIZE("[ERROR] 3이상 25이하여야 합니다.");

    private final String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
