package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputValueConverter;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.OutputViewFormatter;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValueConverter());
        OutputView outputView = new OutputView(new OutputViewFormatter());

        BridgeGameController bridgeGameController = new BridgeGameController(
                inputView,
                outputView);

        bridgeGameController.startBridgeGame();
    }
}
