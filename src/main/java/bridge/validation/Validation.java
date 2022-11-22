package bridge.validation;

import static bridge.command.GameCommand.*;
import static bridge.command.LocationCommand.*;
import static bridge.util.Constant.*;

public class Validation {

    public static void checkBridgeSizeInput(String bridgeLength) {
        checkBridgeLengthConsistOfNum(bridgeLength);
        checkBridgeLengthStartZero(bridgeLength);
        checkBridgeLengthRange3To20(bridgeLength);
    }

    // 다리의 길이 입력값이 숫자인지 검증하는 기능
    private static void checkBridgeLengthConsistOfNum(String bridgeLength) {
        if (bridgeLength.isEmpty() || bridgeLength.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_BLANK_OR_EMPTY);
        }
        if (!bridgeLength.matches(BRIDGE_LENGTH_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_CONSIST_OF_NUM);
        }
    }

    // 다리의 길이 입력값이 0으로 시작하는지 검증하는 기능
    private static void checkBridgeLengthStartZero(String bridgeLength) {
        if (bridgeLength.charAt(0) == ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_START_ZERO);
        }
    }
}
