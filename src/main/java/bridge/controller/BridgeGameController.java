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
        while (shouldIMove(bridgeGame)) {
            outputView.printMap(bridgeGame.getBridgeMap());
        }
        outputView.printMap(bridgeGame.getBridgeMap());
    }

    public boolean shouldIMove(BridgeGame bridgeGame) {
        String moving = inputView.readMoving();
        outputView.printMoving(moving);
        bridgeGame.createMap(moving);
        if (bridgeGame.isGameComplete(moving)) {
            return false;
        }
        return bridgeGame.move(moving) || bridgeGame.retry(outputView.printGameCommand(inputView.readGameCommand()));
    }
}
