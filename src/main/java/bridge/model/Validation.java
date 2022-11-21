package bridge.model;

import bridge.constant.BridgeConstant;
import bridge.constant.ErrorMessage;

public class Validation {

    public static boolean bridgeSizeVerification(String input){
        try{
            valueInRange(isNumber(input));
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean moveDirectionVerification(String input){
        try{
            directionInputValueVerification(formatVerification(input));
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean retryValueVerification(String input){
        try{
            retryInputValueVerification(formatVerification(input));
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    private static int isNumber(String input) throws IllegalArgumentException{
        if(input.length() != input.replaceAll("[^\\d]","").length()){
            throw new IllegalArgumentException(ErrorMessage.NO_NUMERIC_VALUE.getErrorMessage());
        }
        return Integer.parseInt(input);
    }
    private static void valueInRange(int input) throws IllegalArgumentException{
        if(input<3 || input>20){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_IS_WRONG.getErrorMessage());
        }
    }
    private static String formatVerification(String input) throws IllegalArgumentException{
        if(input.length()!=1){
            throw new IllegalArgumentException(ErrorMessage.WRONG_LENGTH.getErrorMessage());
        }
        if(!Character.isUpperCase(input.charAt(0))){
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORMAT.getErrorMessage());
        }
        return input;
    }
    private static void directionInputValueVerification(String input) throws IllegalArgumentException{
        if(input.equals(BridgeConstant.CAN_GO_UP.getString())){
            return;
        }
        if(input.equals(BridgeConstant.CAN_GO_DOWN.getString())){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_FORMAT.getErrorMessage());
    }
    private static void retryInputValueVerification(String input) throws IllegalArgumentException{
        if(input.equals(BridgeConstant.RETRY.getString())){
            return;
        }
        if(input.equals(BridgeConstant.END.getString())){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_FORMAT.getErrorMessage());
    }

}
