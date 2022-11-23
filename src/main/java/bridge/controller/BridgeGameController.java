package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;

    public BridgeGameController() {
        outputView.gameStartPrint();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        outputView.printBridgeSize(bridgeSize);
    }

    public void gameStart() {
        moveControl(bridgeGame);
        outputView.printResult(bridgeGame.getBridgeMap(), bridgeGame.getIsGame(), bridgeGame.getRetryCount());
    }

    public void moveControl(BridgeGame bridgeGame) {
        String moving = inputView.readMoving();
        outputView.printMoving(moving);
        bridgeGame.createMap(moving);
        outputView.printMap(bridgeGame.getBridgeMap());
        confirmRestart(moving);
    }

    private void confirmRestart(String moving) {
        if (bridgeGame.isGameComplete(moving)) {
            return;
        }
        if (bridgeGame.move(moving) || bridgeGame.retry(outputView.printGameCommand(inputView.readGameCommand()))) {
            moveControl(bridgeGame);
        }
    }
}
