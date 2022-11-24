package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.GameResult;
import bridge.model.bridge.Node;
import bridge.view.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private static BridgeGame game;
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run() {
        startGameAndBuildBridge();
        while (!game.isEnd()) {
            goOneStepAndPrintMap();
            checkLastStepAndDecideToContinue();
        }
        printResultAfterEndGame();
    }

    private static void startGameAndBuildBridge() {
        output.printStart();
        int bridgeSize = input.readBridgeSize();
        game = new BridgeGame(bridgeSize);
    }

    private static void goOneStepAndPrintMap() {
        readInputAndMove();
        printMap();
    }

    private static void printMap() {
        String result = game.makeMap();
        output.printMap(result);
    }

    private static void checkLastStepAndDecideToContinue() {
        if (game.lastStepMismatch()) {
            quitOrRetry();
        }
        if (game.complete()) {
            game.quit();
        }
    }

    private static void readInputAndMove() {
        Node to = input.readMoving();
        game.move(to);
    }

    private static void quitOrRetry() {
        GameCommand command = input.readGameCommand();
        if (wantToQuit(command)) {
            game.quit();
            return;
        }
        game.retry();
    }

    private static void printResultAfterEndGame() {
        GameResult result = game.makeResult();
        output.printResult(result);
    }


    private static boolean wantToQuit(GameCommand command) {
        return command == GameCommand.QUIT;
    }
}
