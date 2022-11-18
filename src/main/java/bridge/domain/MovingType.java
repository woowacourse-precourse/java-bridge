package bridge.domain;

import java.util.Arrays;
import static bridge.utils.ErrorMessage.*;

public enum MovingType {
    UP("U", 1),
    DOWN("D", 0);

    private String initial;
    private final int value;

    MovingType(String initial, int value) {
        this.initial = initial;
        this.value = value;
    }

    public static MovingType selectMovingType(int value) {
        return Arrays.stream(MovingType.values())
                .filter(moving -> moving.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(RANDOM_NUMBER_NOT_OPTIONS));
    }

    public String getInitial() {
        return initial;
    }

    public int getValue() {
        return value;
    }
}
