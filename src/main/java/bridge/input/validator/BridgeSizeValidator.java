package bridge.input.validator;

import bridge.input.validator.code.BridgeSizeValidationCode;

public class BridgeSizeValidator {
    private static final int BRIDGE_SIZE_LOWER_BOUND = 3;
    private static final int BRIDGE_SIZE_UPPER_BOUND = 20;

    public BridgeSizeValidationCode validateBridgeSize(String bridgeSizeInput) {
        if (!hasNoIllegalCharacter(bridgeSizeInput)) {
            return BridgeSizeValidationCode.ILLEGAL_CHARACTER;
        }
        if (!isValidNumberFormat(bridgeSizeInput)) {
            return BridgeSizeValidationCode.INVALID_NUMBER_FORMAT;
        }
        if (!isWithinValidRange(Integer.parseInt(bridgeSizeInput))) {
            return BridgeSizeValidationCode.NUMBER_OUT_OF_RANGE;
        }
        return BridgeSizeValidationCode.VALID;
    }

    private boolean hasNoIllegalCharacter(String bridgeSizeInput) {
        assert (bridgeSizeInput != null);

        try {
            Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException | NullPointerException exception) {
            return false;
        }
        return true;
    }

    private boolean isValidNumberFormat(String bridgeSizeInput) {
        assert (hasNoIllegalCharacter(bridgeSizeInput));

        char firstLetter = bridgeSizeInput.charAt(0);

        if (bridgeSizeInput.length() == 1 && firstLetter == '0') {
            return true;
        }
        return firstLetter >= '1' && firstLetter <= '9';
    }

    private boolean isWithinValidRange(int bridgeSize) {
        return bridgeSize >= BRIDGE_SIZE_LOWER_BOUND
                && bridgeSize <= BRIDGE_SIZE_UPPER_BOUND;
    }
}
