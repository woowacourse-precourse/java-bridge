package bridge;

import bridge.controller.BridgeGameProcessor;
import bridge.view.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(
                new InputView(new InputValidator()), new OutputView());
        bridgeGameProcessor.playGame(new BridgeMaker(new BridgeRandomNumberGenerator()));
    }
}
