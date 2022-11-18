package bridge.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 잘못된 숫자가 생성되었습니다."));
    }
}
