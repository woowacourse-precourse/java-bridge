package bridge.domain;

public enum BridgeState {
    DOWN(0),
    UP(1);
    private final int state;

    BridgeState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
