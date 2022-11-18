package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final BridgeGame game = new BridgeGame();
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run() {
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
        if (command.equals("Q")) {
            game.quit();
            return;
        }
        game.retry();
    }
}
