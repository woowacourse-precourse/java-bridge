package bridge;

public class Validation {
    public static void isNotRetryOrQuit(String s){
        if(!s.equals(Constant.RETRY) && !s.equals(Constant.QUIT))
            throw new IllegalArgumentException();
    }
    public static void isNotUpOrDown(String s){
        if(!s.equals(Constant.UP) && !s.equals(Constant.DOWN))
            throw new IllegalArgumentException();
    }
    public static void isBiggerMove(int userMove, int bridgeSize){
        if(userMove>=bridgeSize)
            throw new IllegalArgumentException();
    }
}
