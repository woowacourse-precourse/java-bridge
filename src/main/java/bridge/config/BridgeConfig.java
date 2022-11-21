package bridge.config;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import bridge.controller.BridgeController;
import bridge.generator.BridgeMaker;
import bridge.validator.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeConfig {

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public InputView inputView() {
        return new InputView(validator(), outputView());
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public Validator validator() {
        return new Validator();
    }

    public BridgeController bridgeController() {
        return new BridgeController(inputView(), outputView(), bridgeMaker());
    }
}
