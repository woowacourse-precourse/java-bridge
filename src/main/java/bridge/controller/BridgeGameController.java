package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;

    public BridgeGameController() {
        outputView.startPrint();
        int bridgeLength = inputView.inputBridgeLength();
        bridgeGame = new BridgeGame(bridgeLength);
        outputView.printBridgeLength(bridgeLength);
    }

    private void checkRestart(String moving) {
        if (bridgeGame.isGameComplete(moving)) {
            return;
        }
        if (bridgeGame.move(moving) || bridgeGame.retry(outputView.printCommand(inputView.inputCommand()))) {
            movingControl(bridgeGame);
        }
    }

    public void movingControl(BridgeGame bridgeGame) {
        String moving = inputView.inputMoving();
        outputView.printMoving(moving);
        bridgeGame.createMap(moving);
        outputView.printMap(bridgeGame.getBridgeMap());
        checkRestart(moving);
    }

    public void start() {
        movingControl(bridgeGame);
        outputView.printResult(bridgeGame.getBridgeMap(), bridgeGame.getIsGame(), bridgeGame.getRetryCount());
    }
}