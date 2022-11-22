package bridge.view.constant;

public enum BridgeShape {
    PREFIX_BRIDGE("["), MIDDLE_BRIDGE("|"), SUFFIX_BRIDGE("]"), SAME_DIRECTION(
        " O "), DIFFERENT_DIRECTION(" X "), NONE_DIRECTION("   ");

    private final String shape;

    BridgeShape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
