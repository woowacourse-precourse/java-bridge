package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.BridgeGameView;

public class ResultVerificationStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, BridgeGameView bridgeGameView) {
        bridgeGameView.getOutputView()
                .printResult(context.getCachedHistory(), context.getBridgeGame().isClear(), context.getRepeatCount());
        return new GameEndStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
