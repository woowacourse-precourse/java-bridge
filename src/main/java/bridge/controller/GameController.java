package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
import bridge.view.OutputView;

public class GameController {
    private final OutputView outputView = new OutputView();

    public void play() {
        outputView.printStartGame();
        Bridge bridge = createBridge();
        Diagram diagram = new Diagram();
        BridgeGame bridgeGame = new BridgeGame(bridge, diagram);
        bridgeGame.attempt();
        outputView.printResult(diagram, bridgeGame.isSuccess(), bridgeGame.getAttempts());
    }

    private static Bridge createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(getBridgeSize()));
        return bridge;
    }

}
