package bridge.exeption;

import static bridge.exeption.ExceptionMessage.*;

public class Exception {
    private static final String UPPER = "U";
    private static final String LOWER = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String ZERO = "0";
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
        throwException(input.equals(ZERO),ZERO_INPUT_ERROR.getError());
    }
}
