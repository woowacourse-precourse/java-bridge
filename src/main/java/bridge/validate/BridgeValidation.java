package bridge.validate;

import static bridge.value.BridgeValue.SIZE_END_RANGE;
import static bridge.value.BridgeValue.SIZE_START_RANGE;
import static bridge.value.LocationValue.LOCATION_INIT;

import bridge.value.BridgeCharacter;
import java.util.List;

public class BridgeValidation {

    public static void validateBridgeSize(List<BridgeCharacter> bridge) {
        if (!(SIZE_START_RANGE.getValue() <= bridge.size() && bridge.size() <= SIZE_END_RANGE.getValue())) {
            throw new IllegalArgumentException("다리의 길이가 범위에 해당되지 않습니다.");
        }
    }

    public static void validateBridgeSize(int size) {
        if (!(SIZE_START_RANGE.getValue() <= size && size <= SIZE_END_RANGE.getValue())) {
            throw new IllegalArgumentException("다리의 길이가 범위에 해당되지 않습니다.");
        }
    }

    public static void validateBridgeMovable(boolean isRange) {
        if (!isRange) {
            throw new IllegalStateException("더이상 이동할 수 없습니다.");
        }
    }

    public static void validatePasserLocation(int location) {
        if (location < LOCATION_INIT.getValue()) {
            throw new IllegalArgumentException("다리에서의 위치가 양수가 아닙니다.");
        }
    }
}
