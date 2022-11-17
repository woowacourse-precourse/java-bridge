package bridge.utils;

public class MoveValidator {
    public static void checkMove(String strMove) {
        if(!strMove.equals("U")&&!strMove.equals("D")){
            throw new IllegalArgumentException("[ERROR] U나 D를 입력해야 합니다.");
        }
    }
}
