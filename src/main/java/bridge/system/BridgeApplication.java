package bridge.system;

import bridge.service.BridgeGame;
import bridge.system.controller.BridgeController;
import bridge.system.util.BridgeMaker;
import bridge.system.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeApplication {
    private BridgeController bridgeController;
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeApplication() {
        InjectDependencies();
    }

    public void run() {
        bridgeController.doGame();
    }

    private void InjectDependencies() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        bridgeController = new BridgeController(inputView, outputView, bridgeMaker, bridgeGame);
    }
}
