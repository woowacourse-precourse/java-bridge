package bridge.exeption;

import static bridge.exeption.ExceptionMessage.MOVE_INPUT_ERROR;
import static bridge.exeption.ExceptionMessage.NOT_NUM_ERROR;

public class Exception {
    private static final String UPPER = "U";
    private static final String LOWER = "D";
    private static void throwException(Boolean bool,String error){
        if(bool) throw new IllegalArgumentException(error);
    }
    public static void catchNotNumberException(String input){
        throwException(!input.matches("[0-9]+"),NOT_NUM_ERROR.getError());
    }
    public static void catchMoveInputException(String input){
        throwException(!input.equals(UPPER)&!input.equals(LOWER),MOVE_INPUT_ERROR.getError());
    }
}
