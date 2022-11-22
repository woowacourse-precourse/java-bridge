package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InitStatus implements BridgeGameStatus {

    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        return new GameStartStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }

}
