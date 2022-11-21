package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        outputView.printStartGame();
        Bridge bridge = createBridge();
        Diagram diagram = new Diagram();
        BridgeGame bridgeGame = new BridgeGame(bridge, diagram);
        bridgeGame.attempt();
        outputView.printResult(diagram, bridgeGame.isSuccess(), bridgeGame.getAttempts());
    }

    private Bridge createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

}
