package bridge;

import static bridge.constant.mark.OutputMark.BLANK;

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

    public static String getMarkByMoving(Moving mapMoving, Moving userMoving, String canOrCanNotMove) {
        if (canCross(mapMoving, userMoving)) {
            return canOrCanNotMove;
        }

        return BLANK.getMark();
    }

    private static boolean canCross(Moving mapMoving, Moving userMoving) {
        return mapMoving == userMoving;
    }
}
