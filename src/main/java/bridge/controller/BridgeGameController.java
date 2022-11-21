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
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
    }

    public void gameStart() {
        while (shouldIMove(bridgeGame)) {
            
        }
    }

    public boolean shouldIMove(BridgeGame bridgeGame) {
        String moving = inputView.readMoving();
        if (bridgeGame.isGameComplete(moving)) {
            return false;
        }
        return bridgeGame.move(moving) || bridgeGame.retry(moving);
    }
}
