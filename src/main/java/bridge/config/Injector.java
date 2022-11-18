package bridge.config;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeService;
import bridge.view.InputView;

public class Injector {
    public static InputView getInputView() {
        BridgeGameController bridgeGameController = new BridgeGameController(new BridgeService());
        return new InputView(bridgeGameController);
    }
}
