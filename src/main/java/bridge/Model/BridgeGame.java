package bridge.Model;

public class BridgeGame {

    private static int bridgeSize;

    static {
        bridgeSize = 0;
    }

    public void move() {
    }

    public void retry() {
    }

    public static void saveBridgeSize(final int bridgeSize) {
        BridgeGame.bridgeSize = bridgeSize;
    }

    public static int getBridgeSize() {
        return bridgeSize;
    }
}
