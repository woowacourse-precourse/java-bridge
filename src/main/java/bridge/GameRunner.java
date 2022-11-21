package bridge;

import bridge.controller.GameController;
import bridge.utils.game.GameStatus;
import bridge.view.IOViewResolver;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.function.Consumer;

public final class GameRunner {

    private GameRunner() {
    }

    public static void run(GameStatus gameStatus) {
        IOViewResolver ioViewResolver = createIOViewManager(System.out::println);
        GameController controller = new GameController(ioViewResolver);

        while (gameStatus.playable()) {
            gameStatus = controller.process(gameStatus);
        }
    }

    private static IOViewResolver createIOViewManager(final Consumer<String> print) {
        InputView inputView = new InputView(print);
        OutputView outputView = new OutputView(print);

        return new IOViewResolver(inputView, outputView);
    }
}
