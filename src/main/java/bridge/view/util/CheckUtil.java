package bridge.view.util;

import bridge.domain.GameMessageStorage;

public class CheckUtil {
    public static int checkInputBridgeSize(int bridgeSize,String message) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(message);
        }
        return bridgeSize;
    }

    public static String checkInputReadMoving(String readMove,String message){
        if(!readMove.equals(GameMessageStorage.UP) || !readMove.equals(GameMessageStorage.DOWN)){
            throw new IllegalArgumentException(message);
        }
        return readMove;
    }
}
