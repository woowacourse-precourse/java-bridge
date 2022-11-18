package bridge.system;

import bridge.system.controller.BridgeController;
import bridge.system.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.system.util.BridgeMessageMaker;
import bridge.system.util.BridgeNumberGenerator;
import bridge.system.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameApplication {

    public void execute() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(new BridgeMessageMaker());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();
        BridgeController bridgeController = new BridgeController(inputView, outputView, bridgeGame, bridgeMaker);

        bridgeController.playBridgeGame();
    }
}
