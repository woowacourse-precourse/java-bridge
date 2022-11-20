package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.GameControl;
import bridge.domain.GameStatus;
import bridge.view.OutputView;

public class GameController {
    BridgeGame bridgeGame = new BridgeGame();
    InputController inputController = new InputController();
    OutputView outputView = new OutputView();


    public void run() {
        initialize();
        GameStatus gameStatus = getFinalGameResult();
        outputView.printResult(gameStatus, bridgeGame.getCount());
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
        } while(gameStatus.isPlaying());
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

    private void initialize() {
        int size = inputController.readBridgeSizeUntilSucceed();
        bridgeGame.initialize(size);
    }
}
