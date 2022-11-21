package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ResultVerificationStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        outputView.printResult(context.getCachedHistory(), context.getBridgeGame().isClear(), context.getRepeatCount());
        return new GameEndStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
