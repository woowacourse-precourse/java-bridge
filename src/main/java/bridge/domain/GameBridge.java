
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

    public static String setUpDown(int bridgeNumber) {
        return Arrays.stream(GameBridge.values())
                .filter(o -> o.bridgeNumber == bridgeNumber)
                .map(o -> o.direction).findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력 문구는 U, D 여야 합니다."));
    }
}
