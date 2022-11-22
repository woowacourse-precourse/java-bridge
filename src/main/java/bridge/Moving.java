package bridge;

import bridge.validation.exception.InvalidMovingException;
import java.util.Arrays;

public enum Moving {

    UP("U", 1),
    DOWN("D", 0);

    private final String mark;
    private final int bridgeNumber;

    Moving(String mark, int bridgeNumber) {
        this.mark = mark;
        this.bridgeNumber = bridgeNumber;
    }

    public static Moving from(String mark) {
        return Arrays.stream(Moving.values())
                .filter(moving -> moving.mark.equals(mark))
                .findFirst()
                .orElseThrow(InvalidMovingException::new);
    }

    public static boolean isSame(String mark, Moving moving) {
        return mark.equals(moving.mark);
    }
}
