package bridge.constants;

import java.util.Arrays;

public enum Moving {
    U(1),
    D(0);

    Moving(int number) {
        this.number = number;
    }

    final int number;

    public static Moving getMovingFromNumber(int number) {
        return Arrays.stream(Moving.values())
                .filter(move -> move.number == number)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
