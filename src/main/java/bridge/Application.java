package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = createBridgeGameController();
        bridgeGameController.play();
    }

    private static BridgeGameController createBridgeGameController() {
        InputView inputView = createInputView();
        OutputView outputView = new OutputView();
        return new BridgeGameController(inputView, outputView);
    }

    private static InputView createInputView() {
        InputValidator inputValidator = new InputValidator();
        return new InputView(inputValidator);
    }
}
