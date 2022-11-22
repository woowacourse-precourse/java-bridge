package bridge.config;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeController;
import bridge.service.BridgeService;
import bridge.service.BridgeServiceImpl;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameConfig {

    public static BridgeGame configureBridgeGame() {
        InputView inputView = new InputView(new Validator());
        OutputView outputView = new OutputView();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeService bridgeService = new BridgeServiceImpl(bridgeMaker);

        BridgeController bridgeController = new BridgeController(inputView, outputView, bridgeService);

        return new BridgeGame(bridgeController);
    }
}
