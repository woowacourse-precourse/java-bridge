package bridge.config;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeAppConfig {
    public static InputView inputView() {
        return new InputView();
    }

    public static OutputView outputView() {
        return new OutputView();
    }
}
