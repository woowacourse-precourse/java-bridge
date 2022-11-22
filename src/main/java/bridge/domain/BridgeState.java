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

    public static BridgeState makeBridgeState(String state) {
        BridgeState bridgeState = Arrays.stream(values())
                .filter(value -> value.state.equals(state))
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

    public boolean isSameState(String givenState) {
        if(givenState.equals(this.state)) {
            return true;
        }
        return false;
    }
}
