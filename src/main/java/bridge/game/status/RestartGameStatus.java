package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.BridgeGameView;

public class RestartGameStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, BridgeGameView bridgeGameView) {
        context.getBridgeGame().retry();
        return new PlayerUnitMoveStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
