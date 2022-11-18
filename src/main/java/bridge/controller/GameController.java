package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final String QUIT_COMMAND = "Q";
    private static final BridgeGame game = new BridgeGame();
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run() {
        output.printStart();
        int bridgeSize = input.readBridgeSize();
        game.init(bridgeSize);
        while (game.isEnd()) {
            goOneStep();
        }
        output.printResult();
    }

    private static void goOneStep() {
        moveAndPrintResult();
        if (game.lastChoiceMismatch()) {
            quitOrRetry();
        }
    }

    private static void moveAndPrintResult() {
        String to = input.readMoving();
        game.move(to);
        output.printMap();
    }

    private static void quitOrRetry() {
        String command = input.readGameCommand();
        if (wantToQuit(command)) {
            game.quit();
            return;
        }
        game.retry();
    }

    private static boolean wantToQuit(String command) {
        return command.equals(QUIT_COMMAND);
    }
}
