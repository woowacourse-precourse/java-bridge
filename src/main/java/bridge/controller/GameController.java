package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.bridge.Node;
import bridge.view.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final BridgeGame game = new BridgeGame();
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();

    public static void run() {
        startGameAndBuildBridge();
        while (game.isEnd()) {
            goOneStepAndPrintResult();
            checkLastStepAndDecideToContinue();
        }
        output.printResult();
    }

    private static void startGameAndBuildBridge() {
        output.printStart();
        int bridgeSize = input.readBridgeSize();
        game.init(bridgeSize);
    }

    private static void goOneStepAndPrintResult() {
        readInputAndMove();
        printResultAfterMove();
    }

    private static void printResultAfterMove() {
        List<String> result = new ArrayList<>(2);
        // TODO: game 안에서 bridge 랑 steps를 비교해야함
        output.printMap(result);
    }

    private static void checkLastStepAndDecideToContinue() {
        if (game.lastStepMismatch()) {
            quitOrRetry();
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

    private static boolean wantToQuit(GameCommand command) {
        return command == GameCommand.QUIT;
    }
}
