package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        outputView.printIntro();
        outputView.printRequestBridgeSize();
        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(size);

        BridgeGame bridgeGame = new BridgeGame(bridge);


        outputView.printRequestMove();
        bridgeGame.move(inputView.readMoving());
    }
}
