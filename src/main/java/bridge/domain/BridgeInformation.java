package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

public enum BridgeInformation {
    UP(1, "U"), DOWN(0, "D"), WRONG(-1, "WRONG");

    private final int bridgeNumber;
    private final String bridgePosition;

    BridgeInformation(final int bridgeNumber, final String bridgePosition) {
        this.bridgeNumber = bridgeNumber;
        this.bridgePosition = bridgePosition;
    }

    public static BridgeInformation convertToBridgeInfo(final int bridgeNumber) {
        return Arrays.stream(BridgeInformation.values())
                .filter(bridgeInfo -> Objects.equals(bridgeInfo.bridgeNumber, bridgeNumber))
                .findAny()
                .orElse(WRONG);
    }

    public String getPosition() {
        return this.bridgePosition;
    }
}
