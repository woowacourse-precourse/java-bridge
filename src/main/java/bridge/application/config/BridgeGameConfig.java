package bridge.application.config;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.application.log.Logger;
import bridge.infrastructure.ConsoleLogger;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public Logger logger() {
        return new ConsoleLogger();
    }
}
