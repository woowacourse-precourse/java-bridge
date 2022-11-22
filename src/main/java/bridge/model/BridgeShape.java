package bridge.model;

import bridge.util.Constants.Constant;

import java.util.Arrays;

public enum BridgeShape {
    UP(Constant.UPSIDE, 1),
    DOWN(Constant.DOWN, 0);

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
