package bridge;

import bridge.controller.GameController;
import bridge.utils.game.GameStatus;
import bridge.view.IOViewManager;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.function.Consumer;

public final class GameRunner {

    private GameRunner() {
    }

    public static void run(GameStatus gameStatus) {
        IOViewManager ioViewManager = createIOViewManager(System.out::println);
        GameController controller = new GameController(ioViewManager);

        while (gameStatus.isPlayable()) {
            gameStatus = controller.process(gameStatus);
        }
    }

    private static IOViewManager createIOViewManager(Consumer<String> print) {
        InputView inputView = new InputView(print);
        OutputView outputView = new OutputView(print);

        return new IOViewManager(inputView, outputView);
    }
}
