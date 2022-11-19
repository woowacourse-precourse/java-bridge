package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.service.BridgeGame;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = getBridgeController();
        bridgeController.run();
    }

    public static BridgeController getBridgeController() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, new Player());
        BridgeController bridgeController = new BridgeController(new InputView(), new OutputView(), bridgeGame, new Validator());
        return bridgeController;
    }
}
