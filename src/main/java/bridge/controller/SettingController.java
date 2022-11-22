package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
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
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        outputView.printNewLine();
        BridgeMaker bridgeMaker = getRandomNumberBridgeMaker();
        return new BridgeGame(bridgeMaker, bridgeSize);
    }

    private BridgeMaker getRandomNumberBridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

}
