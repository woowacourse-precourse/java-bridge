package bridge.util;

public class Validator {
    public static boolean isDigit(String input) {
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_DIGIT.print());
            }
        }
        return true;
    }
    public static boolean checkRange(String input) {
        int size=Integer.parseInt(input);
        if(size<Constants.MIN_BRIDGE_SIZE || size>Constants.MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException(ErrorMessage.ERROR_BRIGE_SIZE_RANGE.print());
        }
        return true;
    }
    public static boolean checkMoving(String input){
        if(!input.equals(Constants.MOVE_UP) && !input.equals(Constants.MOVE_DOWN)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_MOVING.print());
        }
        return true;
    }
    public static boolean checkRetryOrQuit(String input){
        if(!input.equals(Constants.RETRY) && !input.equals(Constants.QUIT)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_RETRY_OR_QUIT.print());
        }
        return true;
    }
    public static boolean checkBridgeSize(String input) {
        if(isDigit(input) && checkRange(input)) {
            return true;
        }
        return false;
    }
}
