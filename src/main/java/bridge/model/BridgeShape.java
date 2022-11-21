package bridge.model;

import java.util.Arrays;

public enum BridgeShape {
    UP("U", 1),
    DOWN("D", 0);

    private final String bridgeShape;
    private final int bridgeRandomNumber;

    BridgeShape(String bridgeShape, int bridgeRandomNumber) {
        this.bridgeShape = bridgeShape;
        this.bridgeRandomNumber = bridgeRandomNumber;
    }

    public static String getShapeFromRandomNumber(int bridgeRandomNumber) {
        return Arrays.stream(BridgeShape.values())
                .filter(bridgeShape -> bridgeShape.bridgeRandomNumber == bridgeRandomNumber)
                .findAny()
                .orElseThrow().bridgeShape;
    }
}
