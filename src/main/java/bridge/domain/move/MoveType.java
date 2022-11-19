package bridge.domain.move;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MoveType {
    U(1),
    D(0);

    private final int num;

    MoveType(final int num) {
        this.num = num;
    }

    public static MoveType of(int num) {
        return Arrays.stream(MoveType.values())
                .filter(x -> x.num == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
