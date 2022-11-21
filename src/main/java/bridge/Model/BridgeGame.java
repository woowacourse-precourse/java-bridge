package bridge.Model;

import java.util.List;

public class BridgeGame {

    private static int bridgeSize;
    private static int playCount;
    private final Bridge rightBridge;

    static {
        bridgeSize = 0;
        playCount = 0;
    }

    public BridgeGame(final List<String> bridge) {
        rightBridge = new Bridge(bridge);
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

    public static void plusPlayCount() {
        ++playCount;
    }
}
