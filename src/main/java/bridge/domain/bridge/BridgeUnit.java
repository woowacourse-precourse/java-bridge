package bridge.domain.bridge;

import java.util.Arrays;
import java.util.function.Predicate;

import static bridge.support.ErrorMessage.INVALID_BRIDGE_UNIT_CODE_ERROR;

public enum BridgeUnit {
    DOWN("D", 0),
    UP("U", 1);

    private final String code;
    private final int number;

    BridgeUnit(String code, int number) {
        this.code = code;
        this.number = number;
    }

    public static BridgeUnit from(String code) {
        return from(bridgeUnit -> bridgeUnit.code.equals(code));
    }

    public static BridgeUnit from(int number) {
        return from(bridgeUnit -> bridgeUnit.number == number);
    }

    private static BridgeUnit from(Predicate<BridgeUnit> isEqualToField) {
        return Arrays.stream(BridgeUnit.values())
                .filter(isEqualToField)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_BRIDGE_UNIT_CODE_ERROR));
    }

    public static void validateMoving(String code) {
        from(code);
    }

    public String getCode() {
        return code;
    }
}
