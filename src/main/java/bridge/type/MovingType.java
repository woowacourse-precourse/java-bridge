package bridge.type;

import java.util.Arrays;

public enum MovingType {
    UP("U", 0),
    DOWN("D", 1);

    private final String key;
    private final int value;

    MovingType(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public static MovingType createMoving(String key) {
        return Arrays.stream(MovingType.values())
                .filter(moving -> moving.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
