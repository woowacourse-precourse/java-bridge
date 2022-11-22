package bridge.config;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeController;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.validation.Validator;

public class ClassConfig {
    public Bridge bridge() {
        return new Bridge();
    }

    public InputView inputView() {
        return new InputView(new Validator());
    }

    public OutputView outputView() {
        return new OutputView(bridge());
    }

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public BridgeGame bridgeGame() {
        return new BridgeGame();
    }

    public BridgeController bridgeController() {
        return new BridgeController(this);
    }
}
