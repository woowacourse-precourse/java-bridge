package bridge.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeType {
    U(1),
    D(0);

    private int num;

    BridgeType(final int num) {
        this.num = num;
    }

    public static BridgeType of(int num) {
        return Arrays.stream(BridgeType.values())
                .filter(x -> x.num == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
