package bridge.model;

import static bridge.enums.ErrorMsg.*;

public class InputValidator {

    private static final int BRIDGE_SIZE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_SIZE_UPPER_INCLUSIVE = 20;

    public void BridgeSize(int size) {
        if (size < BRIDGE_SIZE_LOWER_INCLUSIVE || size > BRIDGE_SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_BRIDGE_SIZE_IS_NOT_BETWEEN_3_AND_20.get());
        }
    }
}
