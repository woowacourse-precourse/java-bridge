package bridge.domain;

import static bridge.config.BridgeGameConstants.BRIDGE_MAX_LENGTH;
import static bridge.config.BridgeGameConstants.BRIDGE_MIN_LENGTH;

public class BridgeValidator {
    private static final String UNDER_SIZE_MESSAGE = "입력은 " + BRIDGE_MIN_LENGTH + "이상이어야 합니다";
    private static final String OVER_SIZE_MESSAGE = "입력은 " + BRIDGE_MAX_LENGTH + "이하여야 합니다";

    private BridgeValidator() {
    }

    public static void validateBridgeSize(final int size) {
        if (size < BRIDGE_MIN_LENGTH) {
            throw new IllegalArgumentException(UNDER_SIZE_MESSAGE);
        }
        if (size > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException(OVER_SIZE_MESSAGE);
        }
    }
}
