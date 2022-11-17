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
        return State.DOWN;
    }
}
