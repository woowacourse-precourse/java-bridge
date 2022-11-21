package bridge.domain;

import java.util.Objects;

public enum DirectionType {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String initial;

    DirectionType(int number, String initial) {
        this.number = number;
        this.initial = initial;
    }

    public int getNumber() {
        return number;
    }

    public String getInitial() {
        return initial;
    }

    public static DirectionType valueOfNumber(int number) {
        DirectionType directionType = null;
        if (number == 0) {
            directionType = DOWN;
        }
        if (number == 1) {
            directionType = UP;
        }
        return directionType;
    }

    public static DirectionType valueOfString(String initial) {
        DirectionType directionType = null;
        if (Objects.equals(initial, "D")) {
            directionType = DOWN;
        }
        if (Objects.equals(initial, "U")) {
            directionType = UP;
        }
        return directionType;
    }
}
