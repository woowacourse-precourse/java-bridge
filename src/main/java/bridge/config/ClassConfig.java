package bridge.config;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeController;
import bridge.view.InputView;
import bridge.view.OutputView;
import validation.Validator;

public class ClassConfig {
    public InputView inputView() {
        return new InputView(new Validator());
    }

    public OutputView outputView() {
        return new OutputView();
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
