package bridge.game;

import bridge.game.context.BridgeGameContext;
import bridge.game.status.BridgeGameStatus;
import bridge.game.status.GameEndStatus;
import bridge.game.status.InitStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameLauncher {
    private final BridgeGameContext context;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGameStatus status = new InitStatus();

    public BridgeGameLauncher(final BridgeGameContext context, final InputView inputView, final OutputView outputView) {
        this.context = context;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        while (status.runnable()) {
            try {
                status = status.next(context, inputView, outputView);
            } catch (IllegalStateException exception) {
                status = new GameEndStatus();
                outputView.printError(exception.getMessage());
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }
}
