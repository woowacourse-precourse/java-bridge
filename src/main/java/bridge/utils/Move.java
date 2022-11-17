package bridge.utils;

import java.util.Arrays;

public enum MoveDirection {
    UP("U", 1),
    DOWN("D", 0),
    ERROR("E", -1);

    final String direction;
    final int number;

    public String getDirection() {
        return direction;
    }

    MoveDirection(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public static MoveDirection from(int number) {
        return Arrays.stream(MoveDirection.values())
                .filter(direction -> direction.number == number)
                .findAny()
                .orElse(ERROR);
    }
}
