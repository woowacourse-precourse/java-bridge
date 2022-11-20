package bridge.system;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameApplication {

    public void execute() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();
        BridgeController bridgeController = new BridgeController(inputView, outputView, bridgeGame, bridgeMaker);

        bridgeController.playBridgeGame();
    }
}
