package bridge;

import bridge.message.ErrorMessage;

public class ExceptionController {
    public ExceptionController() {
    }
    public boolean validateBridgeLengthIsNum(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public boolean validateBridgeLengthRange(int num) {
        return ((3 <= num) && (num <= 20));
    }
    public void validateBridgeLength(String bridgeLengthStr) {
        if (!this.validateBridgeLengthIsNum(bridgeLengthStr)) {
            throw new IllegalArgumentException(ErrorMessage.WARNING_BRIDGE_INPUT_TYPE.getErrorMessage());
        }
        int bridgeLength = Integer.parseInt(bridgeLengthStr);
        if (!this.validateBridgeLengthRange(bridgeLength)) {
            throw new IllegalArgumentException(ErrorMessage.WARNING_BRIDGE_SIZE_RANGE.getErrorMessage());
        }
    }
    public void validateBridgeGenerate() {

    }
}
