package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.BridgeGameView;

public interface BridgeGameStatus {

    BridgeGameStatus next(BridgeGameContext context, BridgeGameView bridgeGameView);

    boolean runnable();

}
