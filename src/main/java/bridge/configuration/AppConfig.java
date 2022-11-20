package bridge.configuration;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGameController;
import bridge.view.io.InputView;
import bridge.view.io.OutputView;

public class AppConfig {

    public static BridgeMaker bridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public static BridgeGameController bridgeGameController() {
        return new BridgeGameController(new InputView(), new OutputView());
    }
}
