package view.vo;

import constants.BridgeConstant;
import exception.IllegalArgument;

public class Size {
    private final int size;

    public Size(String sizeInput) {
        validateBridgeSizeInput(sizeInput);
        int size = Integer.parseInt(sizeInput);
        validateBridgeSize(size);
        this.size = size;
    }

    private void validateBridgeSizeInput(String sizeInput) {
        int length = sizeInput.length();

        if (length < BridgeConstant.MIN_SIZE_INPUT_LENGTH || length > BridgeConstant.MAX_SIZE_INPUT_LENGTH) {
            IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        }
        if (sizeInput.chars().allMatch(ch -> Character.isDigit(ch))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
    }

    private void validateBridgeSize(int size) {
        if (size < BridgeConstant.MIN_BRIDGE_SIZE || size > BridgeConstant.MAX_BRIDGE_SIZE) {
            IllegalArgument.handleException(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        }
    }

    public int getSize() {
        return size;
    }
}
