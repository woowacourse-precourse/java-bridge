package bridge.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MoveResult {

    SUCCESS("O", true),
    FAIL("X", false);

    private final String value;

    private final boolean result;

    MoveResult(final String value, final boolean result) {
        this.value = value;
        this.result = result;
    }

    public static MoveResult of(boolean result) {
        return Arrays.stream(MoveResult.values())
                .filter(x -> x.result == result)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public String value() {
        return value;
    }
}
