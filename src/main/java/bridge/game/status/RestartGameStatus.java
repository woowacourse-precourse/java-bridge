package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class RestartGameStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        var restartCommand = inputView.readGameCommand();

        if (restartCommand.isContinue()) {
            context.retry();
            return new PlayerUnitMoveStatus();
        }

        return new ResultVerificationStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
