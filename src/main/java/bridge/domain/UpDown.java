package bridge.domain;

import java.util.Arrays;

public enum UpDown {
    DOWN("D"), UP("U"), NONE("N");

    private String direction;

    UpDown(String direction) {
        this.direction = direction;
    }

    public static String getDirection(int bit) {
        return Arrays.stream(UpDown.values())
                .filter(direction -> direction.ordinal() == bit)
                .findAny()
                .orElse(NONE)
                .direction;
    }
}
