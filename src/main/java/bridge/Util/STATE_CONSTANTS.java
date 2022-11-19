package bridge.Util;

public enum STATE_CONSTANTS {
    RETRY_STATE("R Q"),
    MOVE_STATE("U D");

    private String state;

    STATE_CONSTANTS(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
