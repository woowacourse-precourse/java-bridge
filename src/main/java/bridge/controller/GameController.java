package bridge.controller;

import java.util.List;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.view.OutputView;

public class GameController {

    private final InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        Bridge bridge = createBridge();
        Result result = crossABridge(bridge);
        OutputView.printResult(result);
    }

    private Bridge createBridge() {
        int bridgeSizeInput = inputController.getBridgeSizeInput();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSizeInput);
        return new Bridge(bridge);
    }

    private Result crossABridge(Bridge bridge) {
        Result result = new Result();
        BridgeGame bridgeGame = new BridgeGame(bridge, result, inputController);
        bridgeGame.move();
        return result;
    }
}