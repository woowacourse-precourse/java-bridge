
package bridge.domain;

import java.util.Arrays;

public enum GameBridge {
    U(1, "U"),
    D(0, "D");

    private final int bridgeNumber;
    private final String direction;

    GameBridge(int bridgeNumber, String direction) {
        this.bridgeNumber = bridgeNumber;
        this.direction = direction;
    }
}
