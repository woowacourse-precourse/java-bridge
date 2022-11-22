package bridge.utils;

import static bridge.utils.ErrorEnum.MOVE_NOT_U_OR_D;

public class MoveValidator {
    private final static String upMove="U";
    private final static String downMove="D";

    public static void checkMove(String strMove) {
        if(!strMove.equals(upMove)&&!strMove.equals(downMove)){
            throw new IllegalArgumentException(MOVE_NOT_U_OR_D.getMessage());
        }
    }
}
