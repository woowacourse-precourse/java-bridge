package bridge.utils;


import static bridge.utils.Constants.*;

public class Validation {
    public void validateInteger(String stringValueIsInteger){
        if(stringValueIsInteger.charAt(0) < '0' || stringValueIsInteger.charAt(0) > '9')
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_NOT_INTEGER);
    }

    public void validateNonZero(int bridgeSize){
        if(bridgeSize == 0)
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_IS_ZERO);
    }

    public void validateBridgeSizeInRange3to20(int bridgeSize){
        if(bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_NOT_IN_RANGE);
        }
    }



    public void validatePlayerMove(){

    }

    public void validateRestart(){

    }
}
