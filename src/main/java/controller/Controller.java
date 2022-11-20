package controller;

import bridge.*;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Bridge bridge = createBridge();
        move(bridge);
    }

    private Bridge createBridge() {
        outputView.printGameStart();

        BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private void move(Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        String movingPlace = inputView.readMoving();
        String gameCommand;

        if (!bridgeGame.move(movingPlace)) {
            gameCommand = inputView.readGameCommand();
        }
    }

}
