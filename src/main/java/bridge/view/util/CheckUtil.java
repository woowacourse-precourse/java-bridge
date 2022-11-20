package bridge.view.util;

public class CheckUtil {
    public static void checkInputBridgeSize(int bridgeSize,String message) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(message);
        }
    }
}
