package bridge.constant;

public enum Error {
    SIZE("[ERROR] 3이상 25이하여야 합니다."),
    MOVE("[ERROR] 위, 아래로만 이동할 수 있습니다."),
    STATE("[ERROR] 진행중에만 이동할 수 있습니다."),
    POSITIVE("[ERROR] 1이상이어야 합니다."),
    NUMBER("[ERROR] 숫자여야 합니다.");

    private final String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
