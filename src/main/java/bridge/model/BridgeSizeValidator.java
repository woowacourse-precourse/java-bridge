package bridge.model;

import bridge.view.Constants;
import bridge.view.ErrorMessage;

public class BridgeSizeValidator {
    public final int bridgeSize;

    public BridgeSizeValidator(String bridgeSize) {
        allCheck(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    public void allCheck(String bridgeSize) {
        nullCheck(bridgeSize);
        bridgeSizeIsDigit(bridgeSize);
        bridgeSizeOver(bridgeSize);
    }
    public void nullCheck(String bridgeSize) {
        if(bridgeSize.length() == Constants.ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NULL.getErrorMsg());
        }
    }
    public void bridgeSizeIsDigit(String bridgeSize) {
        for(int i=Constants.ZERO; i<bridgeSize.length(); i++) {
            if(!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.DIGIT.getErrorMsg());
            }
        }
    }

    public void bridgeSizeOver(String bridgeSize) {
        if(Integer.parseInt(bridgeSize) < Constants.MIN_SIZE || Integer.parseInt(bridgeSize) > Constants.MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_RANGE.getErrorMsg());
        }
    }
}
