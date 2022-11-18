package bridge.util;

import static bridge.constant.BridgeConstants.MAX_BRIDGE_SIZE;
import static bridge.constant.BridgeConstants.MIN_BRIDGE_SIZE;

public class InputValidator {
    private static final String BLANK_INPUT_MSG = "비어 있는 입력값 입니다.";
    private static final String NOT_NUMERIC_INPUT_MSG = "숫자 이외의 값이 존재하는 입력값입니다.";
    private static final String INVALID_BRIDGE_SIZE_INPUT = "유효하지 않은 다리 크기입니다.";

    public void validateBridgeSize(String userInput) {
        validateBlank(userInput);
        validateNumeric(userInput);
        validateRange(userInput);
    }

    private void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_MSG);
        }
    }

    private void validateNumeric(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT_MSG);
        }
    }

    private void validateRange(String userInput) {
        int bridgeSize = Integer.parseInt(userInput);

        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_INPUT);
        }
    }
}
