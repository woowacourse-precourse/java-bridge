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
        outputView.printStart();
        outputView.printInputSize();
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
