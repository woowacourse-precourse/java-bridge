package bridge;

import static bridge.BridgeGame.downstairsBridge;
import static bridge.BridgeGame.upstairsBridge;

import java.util.List;

public class GameController {
    public static void bridgeGameProcess() {

        // TODO: 프로그램 구현
        int gameCount = 1;
        OutputView outputView = gameStart();

        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();

        boolean gameQuit = false;
        gameCount = getAnswerProcess(gameCount, outputView, inputView, size, bridge, bridgeGame, gameQuit);

        outputView.printResult(upstairsBridge, downstairsBridge, gameCount, bridgeGame);
    }
    private static OutputView gameStart() {
        OutputView outputView = new OutputView();
        outputView.gameStart();
        return outputView;
    }

    private static int getAnswerProcess(int gameCount, OutputView outputView, InputView inputView, int size, List<String> bridge, BridgeGame bridgeGame, boolean gameQuit) {
        int numberOfTriedAnswers;
        String command;
        do {
            String direction = getMoveCommand(outputView, inputView);
            numberOfTriedAnswers = BridgeGame.getTriedAnswerCount(direction);

            getPrintMapAfterMove(outputView, bridge, bridgeGame, numberOfTriedAnswers, direction);

            if (!BridgeGame.checkWrongAnswer(upstairsBridge, downstairsBridge)) {
                command = getContinueCommand(outputView, inputView);
                gameCount++;
                gameQuit = getGameQuit(command);
            }
        }
        while (!BridgeGame.getGameCompleteStatus(upstairsBridge, downstairsBridge, size) && !gameQuit);
        return gameCount;
    }

    private static String getMoveCommand(OutputView outputView, InputView inputView) {
        outputView.enterMoveDirection();
        return inputView.readMoving();
    }

    private static String getContinueCommand(OutputView outputView, InputView inputView) {
        outputView.getRestartButton();
        String command = inputView.readGameCommand();
        getGameRestart(command);
        return command;
    }

    private static void getPrintMapAfterMove(OutputView outputView, List<String> bridge, BridgeGame bridgeGame, int numberOfTriedAnswers, String direction) {
        bridgeGame.move(direction, bridge, numberOfTriedAnswers);
        outputView.printMap(upstairsBridge, downstairsBridge);
    }

    private static boolean getGameQuit(String command) {
        return !BridgeGame.retry(command);
    }

    private static void getGameRestart(String command) {
        if (BridgeGame.retry(command)) {
            BridgeGame.returnToPreviousStatus(upstairsBridge, downstairsBridge);
        }
    }
}
