package bridge;

import java.util.Arrays;

public enum BridgeSideType {
    UP_STAIRS(1, "U"), DOWN_STAIRS(0, "D");

    private final int number;
    private final String side;

    BridgeSideType(final int number, final String side) {
        this.number = number;
        this.side = side;
    }

    public String getSide() {
        return this.side;
    }

    public static BridgeSideType getFindByNumber(int number) {
        return Arrays.stream(values())
                .filter(bridgeSideType -> bridgeSideType.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMesssage.BRIDGE_STAIRS_TYPE_ERROR.getMessage()));
    }
}
