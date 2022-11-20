package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.BridgeGameView;

public class GameStartStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, BridgeGameView bridgeGameView) {
        bridgeGameView.getOutputView().printGameStartMessage();
        return new GenerateBridgeStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
