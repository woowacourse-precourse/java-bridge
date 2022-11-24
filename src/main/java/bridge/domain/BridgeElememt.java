
package bridge.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeElememt {
    U(1, "U"),
    D(0, "D");

    private final int bridgeNumber;
    private final String direction;

    BridgeElememt(int bridgeNumber, String direction) {
        this.bridgeNumber = bridgeNumber;
        this.direction = direction;
    }

    public static String makeUpDown(int bridgeNumber) {
        return Arrays.stream(BridgeElememt.values())
                .filter(o -> o.bridgeNumber == bridgeNumber)
                .map(o -> o.direction)
                .collect(Collectors.joining());
    }
}
