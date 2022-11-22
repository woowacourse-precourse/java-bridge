package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public interface BridgeGameStatus {

    BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView);

    boolean runnable();

}
