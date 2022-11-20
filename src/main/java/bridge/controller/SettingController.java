package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class SettingController {
    private final InputView inputView;
    private final OutputView outputView;

    public SettingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public BridgeGame setBridgeGame() {
        int bridgeSize = inputBridgeSize();
        BridgeMaker bridgeMaker = getRandomNumberBridgeMaker();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeSize);

        return bridgeGame;
    }

    private int inputBridgeSize() {
        return inputView.readBridgeSize();
    }

    private BridgeMaker getRandomNumberBridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

}
