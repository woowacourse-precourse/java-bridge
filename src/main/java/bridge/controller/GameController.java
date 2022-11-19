package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.GameFlag;
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
        } while (finalGameResult.getFlag() != GameFlag.CLEAR && !needExit());

        return finalGameResult;
    }

    private GameStatus getOneGameResult() {
        GameStatus gameResult;
        do {
            String moving = inputController.readMovingUntilSucceed();
            gameResult = bridgeGame.getMovingResult(moving);
            outputView.printMap(gameResult);
        } while(gameResult.getFlag() == GameFlag.PLAYING);
        return gameResult;
    }

    private boolean needExit() {
        String gameCommand = inputController.readGameCommandUntilSucceed();
        if (gameCommand.equals("Q")) {
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
