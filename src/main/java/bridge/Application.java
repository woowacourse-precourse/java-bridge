package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
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
        BridgeGame bridgeGame = getBridgeGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        return new BridgeController(inputView, outputView, bridgeGame, validator);
    }

    private static BridgeGame getBridgeGame() {
        BridgeMaker bridgeMaker = getBridgeMaker();
        Player player = new Player();
        return new BridgeGame(bridgeMaker, player);
    }

    private static BridgeMaker getBridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }
}
