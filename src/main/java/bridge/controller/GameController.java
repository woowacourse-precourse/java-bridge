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
        GameStatus gameStatus;
        do {
            gameStatus = getOneGameResult();
            if (gameStatus.getFlag() == GameFlag.CLEAR) {
                break;
            }
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("Q")) {
                break;
            }
            bridgeGame.retry();
        } while (gameStatus.getFlag() != GameFlag.CLEAR);

        outputView.printResult(gameStatus, bridgeGame.getCount());
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

    private void initialize() {
        int size = inputView.readBridgeSize();
        bridgeGame.initialize(size);
    }
}
