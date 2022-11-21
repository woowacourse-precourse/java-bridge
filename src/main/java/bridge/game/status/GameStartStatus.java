package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameStartStatus implements BridgeGameStatus {

    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        outputView.printGameStartMessage();
        return new GenerateBridgeStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
