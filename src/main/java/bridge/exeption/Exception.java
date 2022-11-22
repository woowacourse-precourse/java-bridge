package bridge.exeption;

import static bridge.exeption.ExceptionMessage.*;
import static bridge.option.Option.*;

public class Exception {
    private static void throwException(Boolean bool,String error){
        if(bool) throw new IllegalArgumentException(error);
    }
    public static void catchNotNumberException(String input){
        throwException(!input.matches("[0-9]+"),NOT_NUM_ERROR.getError());
    }
    public static void catchMoveInputException(String input){
        throwException(!input.equals(UPPER)&!input.equals(LOWER),MOVE_INPUT_ERROR.getError());
    }
    public static void catchRetryInputException(String input){
        throwException(!input.equals(RETRY)&!input.equals(QUIT), RETRY_INPUT_ERROR.getError());
    }
    public static void catchZeroInputException(String input){
        int inputInt = Integer.parseInt(input);
        throwException(inputInt<MIN|MAX<inputInt, OUT_OF_RANGE_INPUT_ERROR.getError());
    }
}
