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



    public void movingControl(BridgeGame bridgeGame) {
        String moving = inputView.inputMoving();
        outputView.printMoving(moving);

    }

    public void start() {
        movingControl(bridgeGame);

    }
}