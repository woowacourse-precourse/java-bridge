package bridge.domain;

import java.util.List;

public enum MoveIndicator {
    UP("U", 1),
    DOWN("D", 0);

    private final String indicator;
    private final int checkNum;

    MoveIndicator(String indicator, int checkNum) {
        this.indicator = indicator;
        this.checkNum = checkNum;
    }

    public String getIndicator() {
        return indicator;
    }

    public static List<String> all() {
        return List.of(UP.indicator, DOWN.indicator);
    }

    public static String findDirection(int num) {
        if (num == UP.checkNum) {
            return UP.indicator;
        }
        return DOWN.indicator;
    }
}
