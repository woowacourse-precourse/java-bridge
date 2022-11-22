package bridge;

public class Validation {
    public static void isNotRetryOrQuit(String s){
        if(!s.equals(Constant.RETRY) && !s.equals(Constant.QUIT))
            throw new IllegalArgumentException(Constant.ERROR+Constant.ERROR_MESSAGE_RETRY_QUIT);
    }
    public static void isNotUpOrDown(String s){
        if(!s.equals(Constant.UP) && !s.equals(Constant.DOWN))
            throw new IllegalArgumentException(Constant.ERROR+Constant.ERROR_MESSAGE_UP_DOWN);
    }
    public static void isBiggerMove(int userMove, int bridgeSize){
        if(userMove>=bridgeSize)
            throw new IllegalArgumentException(Constant.ERROR+Constant.ERROR_MORE_LENGTH);
    }
    public static void isLengthNumber(String s){
        if(!isInteger(s))
            throw new IllegalArgumentException(Constant.ERROR+Constant.ERROR_IS_NOT_NUMBER);
    }
    public static void isLengthRange(int number){
        if(!(number>=3 && number<=20))
            throw new IllegalArgumentException(Constant.ERROR + Constant.ERROR_MESSAGE_LENGTH);
    }
    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
