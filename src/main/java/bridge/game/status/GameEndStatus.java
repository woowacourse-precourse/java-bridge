package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.BridgeGameView;

public class GameEndStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, BridgeGameView bridgeGameView) {
        return null;
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
