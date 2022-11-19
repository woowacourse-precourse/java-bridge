package bridge.controller;

import bridge.BridgeGame;
import bridge.GameFlag;
import bridge.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
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
            String moving = inputView.readMoving();
            gameResult = bridgeGame.getMovingResult(moving);
            outputView.printMap(gameResult);
        } while(gameResult.getFlag() == GameFlag.PLAYING);
        return gameResult;
    }

    private boolean needExit() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            return true;
        }
        bridgeGame.retry();
        return false;
    }

    private void initialize() {
        int size = inputView.readBridgeSize();
        bridgeGame.initialize(size);
    }
}
