package bridge.config;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeStage;
import bridge.generator.BridgeMaker;
import bridge.validator.Validator;
import bridge.view.InputView;

public class BridgeConfig {

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }
    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public BridgeGame bridgeGame(int size) {
        BridgeMaker bridgeMaker = bridgeMaker();
        return new BridgeGame(bridgeMaker.makeBridge(size));
    }

    public BridgeStage bridgeStage() {
        return new BridgeStage();
    }

    public InputView inputView() {
        return new InputView(validator());
    }

    public Validator validator() {
        return new Validator();
    }
}
