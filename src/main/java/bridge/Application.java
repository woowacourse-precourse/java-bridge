package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView, bridgeMaker);
        bridgeGameController.play();
    }
}
