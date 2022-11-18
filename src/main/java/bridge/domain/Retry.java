package bridge.domain;

import java.util.Arrays;

public enum Retry {
    RETRY("R", true), QUIT("Q", false), NONE("N", false);

    private final String DECISION;
    private final boolean VALUE;

    Retry(String DECISION, boolean VALUE) {
        this.DECISION = DECISION;
        this.VALUE = VALUE;
    }

    public static boolean getValue(String input) {
        return Arrays.stream(Retry.values())
                .filter(retry -> retry.DECISION.equals(input))
                .findAny()
                .orElse(NONE)
                .VALUE;
    }
}
