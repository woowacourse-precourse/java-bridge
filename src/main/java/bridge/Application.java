package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.InputViewConverter;
import bridge.view.OutputView;
import bridge.view.OutputViewConverter;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputViewConverter());
        OutputView outputView = new OutputView(new OutputViewConverter());

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameService bridgeGameService = new BridgeGameService(bridgeMaker);

        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView,
                bridgeGameService);

        bridgeGameController.startBridgeGame();
    }
}
