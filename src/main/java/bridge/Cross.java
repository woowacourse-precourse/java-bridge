package bridge;

import java.util.Arrays;

public enum Cross {

    CAN_CROSS("O", true),
    CAN_NOT_CROSS("X", false);

    private final String mark;
    private final boolean cross;

    Cross(String mark, boolean cross) {
        this.mark = mark;
        this.cross = cross;
    }

    public static Cross from(boolean cross) {
        return Arrays.stream(Cross.values())
                .filter(s -> s.cross == cross)
                .findFirst()
                .orElseGet(null);
    }

    public String getMark() {
        return mark;
    }

    public static boolean canNotCross(Cross cross) {
        return Cross.CAN_NOT_CROSS == cross;
    }
}
