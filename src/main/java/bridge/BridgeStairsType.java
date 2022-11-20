package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeStairsType {
    UP_STAIRS(1, "U"), DOWN_STAIRS(0, "D");

    private final int number;
    private final String stairs;

    BridgeStairsType(final int number, final String stairs) {
        this.number = number;
        this.stairs = stairs;
    }

    public String getStairs() {
        return this.stairs;
    }

    public static BridgeStairsType getFindByNumber(int number) {
        return Arrays.stream(values())
                .filter(bridgeStairsType -> bridgeStairsType.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMesssage.BRIDGE_STAIRS_TYPE_ERROR.getMessage()));
    }
}
