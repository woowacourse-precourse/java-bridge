package bridge.game;

import bridge.game.context.BridgeGameContext;
import bridge.game.status.BridgeGameStatus;
import bridge.game.status.InitStatus;
import bridge.view.BridgeGameView;

public class BridgeGameLauncher {
    private final BridgeGameContext context;
    private final BridgeGameView view;
    private BridgeGameStatus status = new InitStatus();

    public BridgeGameLauncher(final BridgeGameContext context, final BridgeGameView view) {
        this.context = context;
        this.view = view;
    }

    public void execute() {
        while (status.runnable()) {
            status = status.next(context, view);
        }
    }
}
