package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameEndStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        return null;
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
