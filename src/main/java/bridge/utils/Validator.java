package bridge.utils;

public class Validator {

    public static final String NUM_ERROR = "[ERROR] 입력이 숫자가 아닙니다.";
    public static final String MOVE_ERROR = "[ERROR] 이동할 칸은 U, D의 입력만 가능합니다.";
    public static final String RESTART_ERROR = "[ERROR] 재시작은 R, Q의 입력만 가능합니다.";

    public static void isNumber(String number){
        if (!number.matches("[0-9]+")){
            throw new IllegalArgumentException(NUM_ERROR);
        }
    }

    public static void isMoveAlpha(String alpha){
        if (!(alpha.equals("D") || alpha.equals("U"))){
            throw new IllegalArgumentException(MOVE_ERROR);
        }
    }

    public static void isRestart(String alpha){
        if(!(alpha.equals("R") || alpha.equals("Q"))){
            throw new IllegalArgumentException(RESTART_ERROR);
        }
    }
}
