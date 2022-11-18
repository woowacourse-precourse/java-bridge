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

    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeController bridgeController;
    private BridgeMaker bridgeMaker;

    public void execute() {
        inputView = new InputView();
        outputView = new OutputView(new BridgeMessageMaker());
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        bridgeController = new BridgeController(inputView, outputView, bridgeGame, bridgeMaker);

        bridgeController.playBridgeGame();
    }
}
