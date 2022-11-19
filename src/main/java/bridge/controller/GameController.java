package bridge.controller;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController =inputController;
    }

    public void run() {
        Bridge bridge = createBridge();

    }

    private Bridge createBridge() {
        int bridgeSizeInput = inputController.getBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSizeInput);
        return new Bridge(bridge);
    }
}
