package bridge.Model;

public class BridgeGame {

    private static int bridgeSize;

    public void move() {
    }

    public void retry() {
    }


    public static void saveBridgeSize(final int bridgeSize) {
        BridgeGame.bridgeSize = bridgeSize;
    }
}
