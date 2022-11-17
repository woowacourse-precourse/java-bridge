package bridge;

public enum State {
    UP("U"),
    DOWN("D");

    private final String code;

    State(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static State getState(int number) {
        if (number == 1) {
            return State.UP;
        }
        if (number == 0) {
            return State.DOWN;
        }
        throw new IllegalArgumentException("0과 1만 입력할 수 있습니다");
    }
}
