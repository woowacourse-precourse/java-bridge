package bridge.service;

import bridge.controller.BridgeGame;
import bridge.service.constant.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameService {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();

    public BridgeGameService() {
        outputView.printStartMessage();
    }

    public void startBridgeMakingProcess() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.prepare();
        bridgeGame.constructBridge(bridgeSize);
    }
    
}
