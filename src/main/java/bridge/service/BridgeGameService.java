package bridge.service;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameService {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();

    public BridgeGameService() {
        outputView.printStartMessage();
    }

}
