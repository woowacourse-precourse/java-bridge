package bridge.constant;

import java.util.Arrays;

public enum BridgeChoice {
    UP("U", 1),
    DOWN("D", 0);

    private final String side;
    private final int number;

    BridgeChoice(String side, int number) {
        this.side = side;
        this.number = number;
    }

    public static BridgeChoice fromNumber(int number) {
        return Arrays.stream(BridgeChoice.values())
                .filter(bridgeChoice -> bridgeChoice.number == number)
                .findAny()
                .get();
    }

    public String getSide() {
        return side;
    }
}
