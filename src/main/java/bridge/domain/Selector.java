package bridge.domain;

import java.util.Arrays;

public enum Selector {
    U(1),
    D(0);

    Selector(int number) {
        this.number = number;
    }

    private final int number;

    public static Selector getSelectorFromNumber(int number) {
        return Arrays.stream(Selector.values())
                .filter(selector -> selector.number == number)
                .findAny()
                .orElse(null);
    }
}
