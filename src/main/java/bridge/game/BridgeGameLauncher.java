package bridge.game;

import bridge.game.context.BridgeGameContext;
import bridge.game.status.BridgeGameStatus;
import bridge.game.status.GameEndStatus;
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
            try {
                status = status.next(context, view);
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                status = new GameEndStatus();
            }
        }
    }
}
