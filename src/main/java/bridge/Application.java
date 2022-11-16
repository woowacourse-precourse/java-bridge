package bridge;

import bridge.service.BridgeService;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(new BridgeService(new InputView(), new OutputView(), new BridgeMaker(new BridgeRandomNumberGenerator()), new Validator()));
        bridgeGame.run();

    }
}
