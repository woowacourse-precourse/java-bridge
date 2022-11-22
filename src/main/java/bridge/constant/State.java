package bridge.constant;

public enum State {
    Win("성공"), Loss("실패"), Progress("진행중");

    private String msg;

    State(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
