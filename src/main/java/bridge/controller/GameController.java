package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.bridge.Node;
import bridge.model.gameResult.GameResult;
import bridge.model.gameResult.GameResultDTO;
import bridge.model.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

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
        TryCatchTemplate<Integer> bridgeBuildTemplate = new TryCatchTemplate<>() {};
        int bridgeSize = bridgeBuildTemplate.repeatToRunWhileValid(input::readBridgeSize);
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
        TryCatchTemplate<Node> readNextPositionTemplate = new TryCatchTemplate<>() {
        };
        Node to = readNextPositionTemplate.repeatToRunWhileValid(() -> Node.of(input.readMoving()));
        game.move(to);
    }

    private static void quitOrRetry() {
        TryCatchTemplate<GameCommand> readGameCommandTemplate = new TryCatchTemplate<>() {
        };

        GameCommand command = readGameCommandTemplate.repeatToRunWhileValid(() -> GameCommand.of(input.readGameCommand()));
        if (wantToQuit(command)) {
            game.quit();
            return;
        }
        game.retry();
    }

    private static void printResultAfterEndGame() {
        GameResult result = game.makeResult();
        output.printResult(GameResultDTO.of(result));
    }


    private static boolean wantToQuit(GameCommand command) {
        return command == GameCommand.QUIT;
    }
}
