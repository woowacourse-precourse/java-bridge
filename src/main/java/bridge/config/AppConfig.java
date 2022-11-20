package bridge.config;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {

    public static Controller config() {
        return new Controller(new InputView(),
                new BridgeGame(),
                new BridgeMaker(bridgeNumberGenerator()),
                new OutputView());
    }

    public static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
