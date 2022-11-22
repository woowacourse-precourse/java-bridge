package bridge.utils;

import bridge.MODEnum;

import static bridge.MODEnum.DOWN_GO;
import static bridge.MODEnum.UP_GO;
import static bridge.utils.ErrorEnum.MOVE_NOT_U_OR_D;

public class MoveValidator {
    public static void checkMove(String strMove) {
        if(!strMove.equals(UP_GO.getMessage())&&!strMove.equals(DOWN_GO.getMessage())){
            throw new IllegalArgumentException(MOVE_NOT_U_OR_D.getMessage());
        }
    }
}
