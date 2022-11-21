package bridge.validator;

import static bridge.exception.Exception.*;
import static bridge.utils.constant.Constants.*;

public class InputValidator {
    public static void validateBridgeSize(String bridgeSize) {
        validateFormat(bridgeSize);
        validateRange(Integer.parseInt(bridgeSize));
    }

    public static void validateFormat(String bridgeSize) {
        try{
            Integer.parseInt(bridgeSize);
        } catch(NumberFormatException e) {
            NOT_NUMBER.throwException();
        }
    }

    public static void validateRange(int bridgeSize) {
        if(bridgeSize < MIN_RANGE || bridgeSize > MAX_RANGE) {
            OUT_OF_RANGE.throwException();
        }
    }
}
