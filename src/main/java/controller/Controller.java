package controller;

import bridge.*;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Bridge bridge = createBridge();
        String movingPlace = inputView.readMoving();
    }

    private Bridge createBridge() {
        outputView.printGameStart();

        BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

}
