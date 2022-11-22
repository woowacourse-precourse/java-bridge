package bridge.domain.move;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MoveResult {

    SUCCESS("O", "성공", true),
    FAIL("X", "실패", false),
    NOTHING(" ", null, null);

    private final String symbol;

    private final String value;

    private final Boolean result;

    MoveResult(final String symbol, final String value, final Boolean result) {
        this.symbol = symbol;
        this.value = value;
        this.result = result;
    }

    public static MoveResult of(boolean result) {
        return Arrays.stream(MoveResult.values())
                .filter(x -> x.result == result)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public String symbol() {
        return symbol;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
       return value;
    }
}
