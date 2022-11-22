package bridge.validation;

import static bridge.validation.ErrorMessage.*;

public class ReadBridgeSizeValidation {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public void validate(String inputBridgeSize) {
        validateInputIsInteger(inputBridgeSize);
        validateSizeRange(inputBridgeSize);
    }

    public void validateInputIsInteger(String inputBridgeSize) {
        try {
            Integer.parseInt(inputBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_BRIDGE_SIZE_IN_INTEGER.getMessage());
        }
    }

    public void validateSizeRange(String inputBridgeSize) {
        int bridgeSize = Integer.parseInt(inputBridgeSize);

        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_BETWEEN_THREE_AND_TWENTY.getMessage());
        }
    }

}
