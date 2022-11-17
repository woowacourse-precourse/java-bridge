package bridge.domain;

import java.util.Arrays;
import java.util.Optional;

public enum BridgeState {
    UP("U", 1),
    DOWN("D", 0);

    private String playerValue;
    private int bridgeValue;

    BridgeState() {
    }

    BridgeState(String playerValue, int bridgeValue) {
        this.playerValue = playerValue;
        this.bridgeValue = bridgeValue;
    }

    public static Optional<BridgeState> findByBridgeValue(int bridgeValue) {
        return Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.bridgeValue == bridgeValue)
                .findAny();
    }

    public static Optional<BridgeState> findByPlayerValue(String playerValue) {
        return Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.playerValue.equals(playerValue))
                .findAny();
    }

    public String getPlayerValue() {
        return this.playerValue;
    }
}
