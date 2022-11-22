package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeShape {
    DOWN("D", 0),
    UP("U", 1);

    private final String shape;
    private final int number;

    BridgeShape(String shape, int number) {
        this.shape = shape;
        this.number = number;
    }

    public static String getBridgeShapeByNumber(int number) {
        BridgeShape[] bridgeShapes = BridgeShape.values();
        return Arrays.stream(bridgeShapes)
            .filter(bridgeShape -> bridgeShape.number == number)
            .findFirst()
            .orElse(DOWN)
            .shape;
    }

    public static boolean contains(String shape) {
        return Arrays.stream(BridgeShape.values())
            .map(BridgeShape::getShape)
            .collect(Collectors.toList())
            .contains(shape);
    }

    public String getShape() {
        return this.shape;
    }
}
