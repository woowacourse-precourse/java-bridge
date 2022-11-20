package bridge;

import bridge.controller.BridgeGameProcessor;
import bridge.domain.BridgeMaker;
import bridge.view.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        new BridgeGameProcessor(new InputView(new InputValidator()), new OutputView(), new BridgeMaker(new BridgeRandomNumberGenerator())).play();
    }
}
