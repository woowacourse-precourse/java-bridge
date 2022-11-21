package bridge.utils;

import bridge.utils.constants.BridgeSize;

import java.util.regex.Pattern;

public class ValidateUtils {

    public static void isCorrectRangeNumbers(String input){
        if(!Pattern.matches(BridgeSize.BRIDGE_SIZE_REGEX, input)){
            throwIllegalArgumentException(BridgeSize.ERROR_BRIDGE_SIZE_MESSAGE);
        }
    }

    private static void throwIllegalArgumentException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }
}
