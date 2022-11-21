package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ResultVerificationStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        var gameHistory = context.getCachedHistory();
        var gameStatus = context.getBridgeGame().getGameStatus();
        var gameRepeatCount = context.getRepeatCount();

        outputView.printResult(gameHistory, gameStatus.getCode(), gameRepeatCount);
        return new GameEndStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
