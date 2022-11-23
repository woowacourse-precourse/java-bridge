package bridge.view.draw;

import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;

public class BridgeDrawerFactory {

    public static BridgeDrawer createDrawer(BridgeStatus bridgeStatus) {
        GameStatus gameStatus = bridgeStatus.getGameStatus();
        if (gameStatus.isFail()) {
            return new BridgeFailDrawer(bridgeStatus.getUserBridge());
        }
        return new BridgeCommonDrawer(bridgeStatus.getUserBridge());
    }
}
