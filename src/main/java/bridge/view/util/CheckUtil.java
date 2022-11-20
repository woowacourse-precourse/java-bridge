package bridge.view.util;

import bridge.domain.MessageStorage;

public class CheckUtil {
    public static int checkInputBridgeSize(int bridgeSize,String message) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(message);
        }
        return bridgeSize;
    }

    public static String checkInputReadMoving(String readMove,String message){
        if(!readMove.equals(MessageStorage.UP.getMessage()) || !readMove.equals(MessageStorage.DOWN.getMessage())){
            throw new IllegalArgumentException(message);
        }
        return readMove;
    }
}
