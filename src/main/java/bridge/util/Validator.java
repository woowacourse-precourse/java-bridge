package bridge.util;

import static bridge.util.Message.*;

import java.util.regex.Pattern;

public class Validator {
    private static String pattern = "^[0-9]*$";
    private static String MOVING = "^[UD{1}]$";
    private static String END_ORDER = "^[RQ{1}]$";
    private static int MIN_NUMBER = 3;
    private static int MAX_NUMBER = 20;

    public void isRightBridgeGenerateInput(String input){
        isNumber(input);
        isRightRange(input);
    }

    public void isNumber(String input){
        if(!Pattern.matches(pattern,input))
            throw new IllegalArgumentException(GAME_ERROR_LEN);
    }

    public void isRightRange(String input){
        int range = Integer.parseInt(input);
        if(range < MIN_NUMBER || range > MAX_NUMBER)
            throw new IllegalArgumentException(GAME_ERROR_LEN);
    }

    public void isRightOrder(String input){
        if(!Pattern.matches(MOVING,input))
            throw new IllegalArgumentException(GAME_ERROR_MOVE);
    }

    public void isRightEndOrder(String input){
        if(!Pattern.matches(END_ORDER, input))
            throw new IllegalArgumentException(GAME_ERROR_END);
    }
}
