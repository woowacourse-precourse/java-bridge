package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeService;
import bridge.service.BridgeServiceImpl;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Validator());
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeService bridgeService = new BridgeServiceImpl(bridgeMaker);
        BridgeController bridgeController = new BridgeController(inputView, outputView, bridgeService);
        BridgeGame bridgeGame = new BridgeGame(bridgeController);

        try {
            bridgeGame.runGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
