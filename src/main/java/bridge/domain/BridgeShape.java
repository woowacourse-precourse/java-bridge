package bridge.domain;

import bridge.exception.domain.BridgeShapeNumberException;

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
}
