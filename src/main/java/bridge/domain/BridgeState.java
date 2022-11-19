package bridge.domain;

import java.util.Arrays;

public enum BridgeState {
    DOWN("D", 0),
    UP("U", 1);
    private final String state;
    private final int stateValue;

    BridgeState(String state, int stateValue) {
        this.state = state;
        this.stateValue = stateValue;
    }

    public static BridgeState makeBridgeState(int stateValue) {
        BridgeState bridgeState = Arrays.stream(values())
                .filter(value -> value.stateValue == stateValue)
                .findAny()
                .orElse(null);
        return bridgeState;
    }

    public int getStateValue() {
        return stateValue;
    }
    public String getState() {
        return state;
    }
}
