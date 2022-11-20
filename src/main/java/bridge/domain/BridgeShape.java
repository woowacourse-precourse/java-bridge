package bridge.domain;

import bridge.exception.domain.BridgeShapeNumberException;
import bridge.exception.domain.NoSuchBridgeShapeException;
import java.util.Arrays;

public enum BridgeShape {
    DOWN("D"), UP("U");

    private final String shape;

    BridgeShape(String shape) {
        this.shape = shape;
    }

    public static String shape(int number) {
        try {
            return BridgeShape.values()[number].shape;
        } catch (IndexOutOfBoundsException exception) {
            throw new BridgeShapeNumberException(DOWN.ordinal(), UP.ordinal());
        }
    }

    public static BridgeShape of(String shape) {
        return Arrays.stream(BridgeShape.values())
                .filter(bridge -> bridge.shape.equals(shape))
                .findAny()
                .orElseThrow(() -> new NoSuchBridgeShapeException(shape));
    }
}
