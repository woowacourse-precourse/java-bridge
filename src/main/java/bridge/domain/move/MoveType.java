package bridge.domain.move;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum MoveType {
    UP("U", 1),
    DOWN("D", 0);

    private final String symbol;

    private final int num;

    MoveType(final String symbol, final int num) {
        this.symbol = symbol;
        this.num = num;
    }

    public static MoveType of(int num) {
        return Arrays.stream(MoveType.values())
                .filter(x -> x.num == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static MoveType of(String symbol) {
        return Arrays.stream(MoveType.values())
                .filter(x -> Objects.equals(x.symbol, symbol))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String toString() {
        return String.format("MoveType{symbol = %s, num = %d}", symbol, num);
    }

    public String symbol() {
        return symbol;
    }
}
