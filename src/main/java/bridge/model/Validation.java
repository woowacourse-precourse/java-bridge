package bridge.model;

import bridge.constant.ErrorMessage;

public class Validation {
    private static final String ERROR = "[ERROR]";
    public static boolean bridgeSizeValidationTest(String input){
        try{
            valueInRange(isNumber(input));
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    private static int isNumber(String input) throws IllegalArgumentException{
        if(input.length() != input.replaceAll("[^\\d]","").length()){
            throw new IllegalArgumentException(ERROR+ ErrorMessage.NO_NUMERIC_VALUE.getErrorMessage());
        }
        return Integer.parseInt(input);
    }
    private static void valueInRange(int input) throws IllegalArgumentException{
        if(input<3 || input>20){
            throw new IllegalArgumentException(ERROR+ ErrorMessage.NUMBER_RANGE_IS_WRONG.getErrorMessage());
        }
    }
}
