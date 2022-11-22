package bridge;

import java.util.Arrays;

public enum BridgeDirect {
    UP(1,"U"),
    DOWN(0,"D");

    private final int num;
    private final String direction;

    BridgeDirect(int num, String direction) {
        this.num = num;
        this.direction = direction;
    }

    public static String numToDirection(int num) {
        return valueOfNum(num).direction;
    }

    public static BridgeDirect valueOfNum(int num) {
        return Arrays.stream(values())
                .filter(value -> value.num == num)
                .findAny()
                .orElse(null);
    }

    public static BridgeDirect valueOfDirection(String direction) {
        return Arrays.stream(values())
                .filter(value -> value.direction.equals(direction))
                .findAny()
                .orElse(null);
    }


    public String getDirection() {
        return direction;
    }
}
