package bridge.enums;

import java.util.Arrays;
import static bridge.utils.ErrorMessage.*;

public enum MovingType {
    UP("U", 1),
    DOWN("D", 0);

    private String initial;
    private final int code;

    MovingType(String initial, int code) {
        this.initial = initial;
        this.code = code;
    }

    public static MovingType selectMovingTypeByCode(int code) {
        return Arrays.stream(MovingType.values())
                .filter(moving -> moving.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NUMBER_NOT_OPTIONS));
    }

    public static MovingType selectMovingTypeByInitial(String initial) {
        return Arrays.stream(MovingType.values())
                .filter(moving -> moving.initial.equals(initial))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MOVING_NOT_OPTIONS));
    }

    public String getInitial() {
        return initial;
    }

    public int getCode() {
        return code;
    }
}
