package util;

import enums.ErrorMessage;

import java.util.regex.Pattern;

public class ValidationUtil {
    public static String isValidSize(String size){
        if(!Pattern.matches("^[3~20]$", size)) throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getValue());
        return size;
    }

    public static String isValidMoving(String moving) {
        if( !Pattern.matches("^[UD]$", moving) ) throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING_SPOT.getValue());
        return moving;
    }

    public static String isValidRetry(String retrial) {
        if( !Pattern.matches("^[RG]$", retrial) ) throw new IllegalArgumentException(ErrorMessage.INVALID_RETRIAL.getValue());
        return retrial;
    }

}
