package bridge;

import static bridge.BridgeGame.downstairsBridge;
import static bridge.BridgeGame.upstairsBridge;

import java.util.List;


public class Application {

    public static void main(String[] args) {

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
            numberOfTriedAnswers = BridgeGame.getAnswerCount(direction);

            getPrintMapAfterMove(outputView, bridge, bridgeGame, numberOfTriedAnswers, direction);

            if (!bridgeGame.checkWrongAnswer(upstairsBridge, downstairsBridge)) {
                command = getContinueCommand(outputView, inputView, bridgeGame);
                gameCount++;
                gameQuit = getGameQuit(gameCount, bridgeGame, command);
            }
        }
        while (!bridgeGame.getGameCompleteStatus(upstairsBridge, downstairsBridge, size) && !gameQuit);
        return gameCount;
    }

    private static String getMoveCommand(OutputView outputView, InputView inputView) {
        outputView.enterMoveDirection();
        String direction = inputView.readMoving();
        return direction;
    }

    private static String getContinueCommand(OutputView outputView, InputView inputView, BridgeGame bridgeGame) {
        outputView.getRestartButton();
        String command = inputView.readGameCommand();
        getGameRestart(bridgeGame, command);
        return command;
    }

    private static void getPrintMapAfterMove(OutputView outputView, List<String> bridge, BridgeGame bridgeGame, int numberOfTriedAnswers, String direction) {
        bridgeGame.move(direction, bridge, numberOfTriedAnswers);
        outputView.printMap(upstairsBridge, downstairsBridge);
    }

    private static boolean getGameQuit(int gameCount, BridgeGame bridgeGame, String command) {
        if (!bridgeGame.retry(command)) {
            return true;
        }
        return false;
    }

    private static int gameCountWhenQuit(int gameCount, BridgeGame bridgeGame, String command ) {
        if (!bridgeGame.retry(command)) {
            return gameCount - 1;
        }
        return gameCount;
    }

    private static void getGameRestart(BridgeGame bridgeGame, String command) {
        if (bridgeGame.retry(command)) {
            bridgeGame.returnToPreviousStatus(upstairsBridge, downstairsBridge);
        }
    }
}

//게임 카운트 집계 안됨
//게임 실패시 게임 종료 얀됨