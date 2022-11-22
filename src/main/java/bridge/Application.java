package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(initInputView(), initOutputView());
        bridgeGameController.run();
    }

    private static InputView initInputView() {
        return new InputViewProxy(new InputView());
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}
