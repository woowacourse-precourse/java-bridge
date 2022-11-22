package bridge.configuration;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGameController;
import bridge.view.io.InputView;
import bridge.view.io.OutputView;
import bridge.view.io.UserIOView;

public class AppConfig {

    public static BridgeMaker bridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public static BridgeGameController bridgeGameController() {
        return new BridgeGameController(userIOView());
    }

    public static UserIOView userIOView() {
        return new UserIOView(new InputView(), new OutputView());
    }
}
