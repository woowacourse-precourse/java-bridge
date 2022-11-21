package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.GameControl;
import bridge.domain.GameStatus;
import bridge.view.OutputView;

public class GameController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();

    public void run() {
        initializeGame();
        GameStatus finalGameStatus = getFinalGameResult();
        outputView.printResult(finalGameStatus);
    }

    private GameStatus getFinalGameResult() {
        GameStatus finalGameResult;
        do {
            finalGameResult = getOneGameResult();
        } while (!finalGameResult.isClear() && !needExit());

        return finalGameResult;
    }

    private GameStatus getOneGameResult() {
        GameStatus gameStatus;
        do {
            String moving = inputController.readMovingUntilSucceed();
            gameStatus = bridgeGame.getMovingResult(moving);
            outputView.printMap(gameStatus);
        } while (gameStatus.isPlaying());
        return gameStatus;
    }

    private boolean needExit() {
        String gameCommand = inputController.readGameCommandUntilSucceed();
        if (GameControl.isQuit(gameCommand)) {
            return true;
        }
        bridgeGame.retry();
        return false;
    }

    private void initializeGame() {
        int size = inputController.readBridgeSizeUntilSucceed();
        bridgeGame.initAnswerBridge(size);
    }
}
