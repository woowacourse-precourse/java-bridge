package bridge.Model;

import java.util.Arrays;

public enum BridgeShape {
    UP(1, "U"), DOWN(0, "D"), EMPTY(-1, "");

    private final int index;
    private final String shape;

    BridgeShape(int index, String shape) {
        this.index = index;
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public static String findShapeByIndex(int index) {
        BridgeShape result = Arrays.stream(BridgeShape.values())
                .filter(bridgeShape -> bridgeShape.index == index)
                .findAny()
                .orElse(EMPTY);

        return result.shape;
    }
}
