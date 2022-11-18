package bridge.system;

import bridge.service.BridgeGame;
import bridge.system.controller.GameController;
import bridge.system.util.BridgeMaker;
import bridge.system.util.BridgeMessageMaker;
import bridge.system.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeApplication {
    private GameController gameController;
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeApplication() {
        InjectDependencies();
    }

    public void run() {
        gameController.doGame();
    }

    private void InjectDependencies() {
        inputView = new InputView();
        outputView = new OutputView(new BridgeMessageMaker());
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(outputView, inputView);
        gameController = new GameController(inputView, outputView, bridgeMaker, bridgeGame);
    }
}
