package bridge.config;

import bridge.*;
import bridge.validation.Validation;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {

    public static Controller config() {
        return new Controller(new InputView(validation()),
                new BridgeGame(),
                new BridgeMaker(bridgeNumberGenerator()),
                new OutputView());
    }

    public static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public static Validation validation() {
        return new Validation();
    }
}
