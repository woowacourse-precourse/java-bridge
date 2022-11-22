package bridge.Model;

import bridge.Constant.BridgeValue;
import java.util.List;

public class BridgeGame {

    private static int bridgeSize;
    private final Bridge rightBridge;

    static {
        bridgeSize = 0;
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

    public void retry() {
    }

    public static void saveBridgeSize(final int bridgeSize) {
        BridgeGame.bridgeSize = bridgeSize;
    }

    public static int getBridgeSize() {
        return bridgeSize;
    }
}
