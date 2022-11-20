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
}
