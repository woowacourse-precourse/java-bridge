package bridge.domain;

import java.util.Arrays;

public enum BridgeState {
    UP("U", 1),
    DOWN("D", 0),
    EMPTY();

    private String userValue;
    private int bridgeValue;

    BridgeState() {
    }

    BridgeState(String userValue, int bridgeValue) {
        this.userValue = userValue;
        this.bridgeValue = bridgeValue;
    }

    public static BridgeState valueOfBridge(int bridgeValue) {
        return Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.bridgeValue == bridgeValue)
                .findAny()
                .orElse(EMPTY);
    }

    public static BridgeState valueOfUser(String userValue) {
        return Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.userValue.equals(userValue))
                .findAny()
                .orElse(EMPTY);
    }

    public String getUserValue() {
        return this.userValue;
    }
}
