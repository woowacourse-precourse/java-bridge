package bridge.validate;

import static bridge.message.ErrorMessage.IMMOVABLE_STATE;
import static bridge.message.ErrorMessage.INPUT_SIZE_NOT_INTEGER;
import static bridge.message.ErrorMessage.INPUT_SIZE_OUT_OF_RANGE;
import static bridge.message.ErrorMessage.NEGATIVE_BRIDGE_LENGTH;
import static bridge.message.ErrorMessage.UNEXPECTED_BRIDGE_CHARACTER;
import static bridge.message.ErrorMessage.UNEXPECTED_BRIDGE_VALUE;
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
            throw new IllegalArgumentException(INPUT_SIZE_OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateBridgeSizeInput(String inputValue) {
        try {
            Integer.parseInt(inputValue);

        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(INPUT_SIZE_NOT_INTEGER.getMessage());
        }
    }

    public static void validateBridgeMovable(boolean isRange) {
        if (!isRange) {
            throw new IllegalStateException(IMMOVABLE_STATE.getMessage());
        }
    }

    public static void validatePasserLocation(int location) {
        if (location < LOCATION_INIT.getValue()) {
            throw new IllegalArgumentException(NEGATIVE_BRIDGE_LENGTH.getMessage());
        }
    }

    public static void validateBridgeValue(int value) {
        Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.getValue() == value)
                .findAny().orElseThrow(() -> new IllegalArgumentException(UNEXPECTED_BRIDGE_VALUE.getMessage()));
    }

    public static void validateBridgeCharacter(String character) {
        Arrays.stream(BridgeCharacter.values())
                .filter(bridgeCharacter -> bridgeCharacter.getCharacter().equals(character))
                .findAny().orElseThrow(() -> new IllegalArgumentException(UNEXPECTED_BRIDGE_CHARACTER.getMessage()));
    }
}
