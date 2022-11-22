package bridge.Model;

import bridge.Constant.BridgeValue;
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

    public boolean move(final String input, final BridgeMap bridgeMap, final int position) {
        if(BridgeValue.UP.value().equals(input)) {
            return bridgeMap.isCrossUp(rightBridge, position);
        }
        if(BridgeValue.DOWN.value().equals(input)) {
            return bridgeMap.isCrossDown(rightBridge, position);
        }
        return false;
    }

    public boolean retry(final String input) {
        return (BridgeValue.RESTART.value()).equals(input);
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

    public static int getPlayCount() {
        return playCount;
    }
}
