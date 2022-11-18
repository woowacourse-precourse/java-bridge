package bridge.controller;

import bridge.config.BridgeConfig;
import bridge.domain.BridgeGame;
import bridge.view.InputView;

public class BridgeController {
    BridgeConfig bridgeConfig = new BridgeConfig();

    InputView inputView = bridgeConfig.inputView();
    BridgeGame bridgeGame;

    public void initBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();

        bridgeGame = bridgeConfig.bridgeGame(bridgeSize);
    }


}
