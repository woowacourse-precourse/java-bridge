package bridge.controller;

import bridge.BridgeGame;
import bridge.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public void run() {
        initialize();
        GameStatus finalResult = getOneGameResult();
        outputView.printMap(finalResult);
    }

    private GameStatus getOneGameResult() { // 정상적인 경우가 아니라면 루프 종료
        GameStatus gameResult;
        do {
            String moving = inputView.readMoving();
            gameResult = bridgeGame.getMovingResult(moving);
            outputView.printMap(gameResult);
        } while(gameResult.getFlag() == -1);
        return gameResult;
    }

    private void initialize() {
        int size = inputView.readBridgeSize();
        bridgeGame.initialize(size);
    }

    private void retry() {
        bridgeGame.retry();
    }
}
