package bridge.constant;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final Integer direction;
    private final String directionFirstLetter;

    BridgeDirection(Integer direction, String directionFirstLetter) {
        this.direction = direction;
        this.directionFirstLetter = directionFirstLetter;
    }

    public static String convertToString(Integer direction) {
        if (direction == UP.direction) {
            return UP.directionFirstLetter;
        }
        return DOWN.directionFirstLetter;
    }
}
