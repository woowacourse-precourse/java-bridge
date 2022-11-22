package bridge.position;

import java.util.Arrays;

public enum Latitude {
    DOWN("D"), UP("U");
    private final String direction;

    Latitude(String direction) {
        this.direction = direction;
    }

    public static boolean contains(String direction) {
        return valueOfDirection(direction) != null;
    }

    public static String getDirectionByOrdinal(int ordinal) {
        return Latitude.values()[ordinal].direction;
    }

    public static Latitude valueOfDirection(String direction) {
        return Arrays.stream(values())
                .filter(value -> value.direction.equals(direction))
                .findAny()
                .orElse(null);
    }
}
