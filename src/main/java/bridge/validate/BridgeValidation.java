package bridge.validate;

import static bridge.value.BridgeValue.SIZE_END_RANGE;
import static bridge.value.BridgeValue.SIZE_START_RANGE;
import static bridge.value.LocationValue.LOCATION_INIT;

import bridge.value.BridgeCharacter;
import java.util.Arrays;
import java.util.List;

public class BridgeValidation {

    public static void validateBridgeSize(List<BridgeCharacter> bridge) {
        validateBridgeSize(bridge.size());
    }

    public static void validateBridgeSize(int size) {
        if (!(SIZE_START_RANGE.getValue() <= size && size <= SIZE_END_RANGE.getValue())) {
            throw new IllegalArgumentException("다리의 길이가 범위에 해당되지 않습니다.");
        }
    }

    public static void validateBridgeSizeInput(String inputValue) {
        try {
            Integer.parseInt(inputValue);

        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("다리의 길이 형식인 정수 형식이 아닙니다.");
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

    public static void validateBridgeValue(int value) {
        Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.getValue() == value)
                .findAny().orElseThrow(() -> new IllegalArgumentException("입력한 값에 해당하는 위치 문자가 존재하지 않습니다."));
    }

    public static void validateBridgeCharacter(String character) {
        Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.getCharacter().equals(character))
                .findAny().orElseThrow(() -> new IllegalArgumentException("입력한 위치 문자가 존재하지 않습니다."));
    }
}
