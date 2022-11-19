package bridge.exeption;

import static bridge.exeption.ExceptionMessage.NOT_NUM_ERROR;

public class Exception {
    private static void throwException(Boolean bool,String error){
        if(bool) throw new IllegalArgumentException(error);
    }
    public static void catchNotNumberException(String input){
        throwException(!input.matches("[0-9]+"),NOT_NUM_ERROR.getError());
    }
}
