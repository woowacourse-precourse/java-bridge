package bridge.validation;

import bridge.validation.enums.ErrorMessage;
import bridge.validation.enums.RegEx;
import java.util.regex.Pattern;

public class BridgeSizeValidation {
    private ErrorMessage message;
    private RegEx regEx;

    public BridgeSizeValidation() {
    }

    public boolean isValidate(String bridgeSize) {
        try {
            isNull(bridgeSize);
            isBlank(bridgeSize);
            isNumber(bridgeSize);
            isCorrectRange(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }

    public void throwError(String message) {
        throw new IllegalArgumentException(message);
    }

    public void isNull(String bridgeSize) {
        if (bridgeSize.isEmpty()) {
            message = ErrorMessage.valueOf("NULL_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isBlank(String bridgeSize) {
        if (bridgeSize.isBlank() && bridgeSize.length() != 0) {
            message = ErrorMessage.valueOf("BLANK_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isNumber(String bridgeSize) {
        regEx = RegEx.valueOf("NUMBER_REG_EX");
        if (!Pattern.matches(regEx.getRegEx(), bridgeSize)) {
            message = ErrorMessage.valueOf("NUMBER_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isCorrectRange(String bridgeSize) {
        regEx = RegEx.valueOf("BRIDGE_SIZE_REG_EX");
        if (!Pattern.matches(regEx.getRegEx(), bridgeSize)) {
            message = ErrorMessage.valueOf("RANGE_EXCEPTION");
            throwError(message.getMessage());
        }
    }
}