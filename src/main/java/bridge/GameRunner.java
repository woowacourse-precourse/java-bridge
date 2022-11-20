package bridge;

import bridge.controller.GameController;
import bridge.utils.game.GameStatus;
import bridge.view.IOViewManager;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class GameRunner {

    private GameRunner() {
    }

    public static void run(GameStatus gameStatus) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        IOViewManager ioViewManager = new IOViewManager(inputView, outputView);
        GameController controller = new GameController(ioViewManager);

        while (gameStatus.isPlayable()) {
            gameStatus = controller.process(gameStatus);
        }
    }
}
