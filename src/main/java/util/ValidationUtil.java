package util;

import enums.ErrorMessage;

public class ValidationUtil {

    public static int isValidSize(int size){
        if(size < 3 || size > 20) throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getValue());
        return size;
    }
}
