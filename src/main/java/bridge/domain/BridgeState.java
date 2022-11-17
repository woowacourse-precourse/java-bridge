package bridge.domain;

import java.util.Arrays;
import java.util.Optional;

public enum BridgeState {
    UP("U", 1),
    DOWN("D", 0);

    private String userValue;
    private int bridgeValue;

    BridgeState() {
    }

    BridgeState(String userValue, int bridgeValue) {
        this.userValue = userValue;
        this.bridgeValue = bridgeValue;
    }

    public static Optional<BridgeState> valueOfBridge(int bridgeValue) {
        return Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.bridgeValue == bridgeValue)
                .findAny();
    }

    public static Optional<BridgeState> valueOfUser(String userValue) {
        return Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.userValue.equals(userValue))
                .findAny();
    }

    public String getUserValue() {
        return this.userValue;
    }
}
