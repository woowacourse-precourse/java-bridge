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
            throw new IllegalArgumentException(Constant.ERROR+Constant.ERROR_MESSAGE_LENGTH);
    }
    public static void isLengthNumber(String s){
        if(!s.matches("[1-9][1-9][1-9]"))
            throw new IllegalArgumentException(Constant.ERROR+Constant.ERROR_IS_NOT_NUMBER);
    }
}
