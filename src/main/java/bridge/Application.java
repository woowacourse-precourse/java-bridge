package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.bridge_maker.BridgeMaker;
import bridge.domain.bridge_maker.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.OutputViewFormatter;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(new OutputViewFormatter());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGameController bridgeGameController = new BridgeGameController(
                inputView,
                outputView,
                bridgeMaker);

        bridgeGameController.startBridgeGame();
    }
}
