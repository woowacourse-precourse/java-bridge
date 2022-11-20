package bridge.util;

public class Validator {
    public static boolean isDigit(String input){
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_DIGIT.print());
            }
        }
        return true;
    }
    public static boolean checkRange(String input){
        int size=Integer.parseInt(input);
        if(size<Constants.MIN_BRIDGE_SIZE || size>Constants.MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException(ErrorMessage.ERROR_BRIGE_SIZE_RANGE.print());
        }
        return true;
    }
}
