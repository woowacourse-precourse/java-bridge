package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGameService;
import bridge.view.InputValueConverter;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.OutputViewFormatter;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValueConverter());
        OutputView outputView = new OutputView(new OutputViewFormatter());

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameService bridgeGameService = new BridgeGameService(bridgeMaker);

        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView,
                bridgeGameService);

        bridgeGameController.startBridgeGame();
    }
}
