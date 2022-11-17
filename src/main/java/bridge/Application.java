package bridge;

import bridge.controller.BridgeGameController;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView, bridgeMaker);
        bridgeGameController.play();
    }
}