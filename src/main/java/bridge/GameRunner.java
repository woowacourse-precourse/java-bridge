package bridge;

import bridge.controller.GameController;
import bridge.utils.common.BridgeConst;
import bridge.utils.game.GameStatus;
import bridge.utils.message.ExceptionMessageUtils;
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
            gameStatus = processGameRunner(controller, gameStatus);
        }
    }

    private static IOViewResolver createIOViewManager(final Consumer<String> print) {
        InputView inputView = new InputView(print);
        OutputView outputView = new OutputView(print);

        return new IOViewResolver(inputView, outputView);
    }

    private static GameStatus processGameRunner(final GameController controller, final GameStatus gameStatus) {
        try {
            return controller.process(gameStatus);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            String exceptionFullMessage = String
                    .format(BridgeConst.ERROR_FORMAT, ExceptionMessageUtils.WRONG_CONFIGURATION.getMessage());
            System.out.println(exceptionFullMessage);
            return GameStatus.APPLICATION_EXIT;
        }
    }
}
