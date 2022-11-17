package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeKey {
    UP(1, "U"),
    DOWN(0, "D");

    private int bridgeNumber;
    private String bridgeKey;

    BridgeKey(int bridgeNumber, String bridgeKey) {
        this.bridgeNumber = bridgeNumber;
        this.bridgeKey = bridgeKey;
    }

    public static String bridgeKey(int inputNumber) {
        return Arrays.stream(BridgeKey.values())
                .filter(bridgeKey1 -> bridgeKey1.getBridgeNumber() == inputNumber)
                .map(BridgeKey::getBridgeKey)
                .collect(Collectors.joining());
    }

    public int getBridgeNumber() {
        return bridgeNumber;
    }

    public String getBridgeKey() {
        return bridgeKey;
    }
}
