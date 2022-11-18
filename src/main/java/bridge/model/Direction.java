package bridge.model;

public enum Direction {
    D, U;

    public static String getName(int value) {
        for (Direction direction : values()) {
            if (direction.ordinal() == value)
                return direction.name();
        }
        return null;
    }
}
