package bridge.model;

import java.util.Arrays;

public enum Move {
    U(1),
    D(0);

    private final int number;

    Move(int number) {
        this.number = number;
    }

    public static String getMoving(int moving) {
        return Arrays.stream(Move.values())
                .filter(value -> moving == value.number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""))
                .toString();
    }
}
