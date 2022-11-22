package bridge.domain;

import bridge.exception.IllegalArgumentError;

public enum Direction {
    UP(1, "U", 0),
    DOWN(0, "D", 1);

    private final int directionInt;
    private final String directionString;
    private final int index;

    Direction(int directionInt, String directionString, int index) {
        this.directionString = directionString;
        this.directionInt = directionInt;
        this.index = index;
    }

    public static int getSize() {
        return values().length;
    }

    public static Direction toDirection(String moving) {
        for (Direction direction : values()) {
            if (direction.getDirectionString().equals(moving)) {
                return direction;
            }
        }
        throw new IllegalArgumentError("올바르지 않은 방향입니다.");
    }

    public static Direction toDirection(int moving) {
        for (Direction direction : values()) {
            if (direction.getDirectionInt() == moving) {
                return direction;
            }
        }
        throw new IllegalArgumentError("올바르지 않은 방향입니다.");
    }

    public int getIndex() {
        return index;
    }

    public int getDirectionInt() {
        return directionInt;
    }

    public String getDirectionString() {
        return directionString;
    }
}
