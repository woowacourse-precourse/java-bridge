package bridge.view.util;

public class CheckUtil {
    private static final String up = "U";
    private static final String down = "D";
    public static int checkInputBridgeSize(int bridgeSize,String message) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(message);
        }
        return bridgeSize;
    }

    public static String checkInputReadMoving(String readMove,String message){
        if(!readMove.equals(up) || !readMove.equals(down)){
            throw new IllegalArgumentException(message);
        }
        return readMove;
    }
}
