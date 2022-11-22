package bridge.type;

import bridge.ExceptionMesssage;
import java.util.Arrays;

public enum BridgeSideType {

    UPPER_SIDE(1, "U"),
    LOWER_SIDE(0, "D");

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
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMesssage.BRIDGE_SIDE_TYPE_ERROR.getMessage()));
    }
}
