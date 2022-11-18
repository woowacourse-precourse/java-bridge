package bridge.validator;

import static bridge.utils.BridgeConstant.MAXIMUM_BRIDGE_SIZE;
import static bridge.utils.BridgeConstant.MINIMUM_BRIDGE_SIZE;

import bridge.utils.message.ErrorMessage;

public class BridgeSizeValidator implements Validator {
    @Override
    public void validate(String inputValue) {
        if (isNonNumericValue(inputValue)) {
            System.out.println(ErrorMessage.NON_NUMERIC_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
        if (inputValue.isBlank()) {
            System.out.println(ErrorMessage.BLANK_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
        if (isInValidBridgeSize(inputValue)) {
            System.out.println(String.format(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage(), MINIMUM_BRIDGE_SIZE,
                    MAXIMUM_BRIDGE_SIZE));
            throw new IllegalArgumentException();
        }
    }

    private boolean isNonNumericValue(String inputValue) {
        return !inputValue.chars().allMatch(Character::isDigit);
    }

    private boolean isInValidBridgeSize(String inputValue) {
        int bridgeSize = Integer.parseInt(inputValue);
        return bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE;
    }
}
