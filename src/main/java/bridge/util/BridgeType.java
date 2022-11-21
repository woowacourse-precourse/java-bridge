package bridge.util;

import java.util.Objects;

public enum BridgeType {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String initial;

    BridgeType(int number, String initial) {
        this.number = number;
        this.initial = initial;
    }

    public int getNumber() {
        return number;
    }

    public String getInitial() {
        return initial;
    }

    public static BridgeType valueOfNumber(int number) {
        BridgeType bridge = null;
        if (number == 0) {
            bridge = DOWN;
        }
        if (number == 1) {
            bridge = UP;
        }
        return bridge;
    }

    public static BridgeType valueOfString(String initial) {
        BridgeType bridge = null;
        if (Objects.equals(initial, "D")) {
            bridge = DOWN;
        }
        if (Objects.equals(initial, "U")) {
            bridge = UP;
        }
        return bridge;
    }
}
