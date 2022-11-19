package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.utils.InputHandler;
import bridge.utils.enums.GameResult;
import java.util.List;

public class GameController {

    private final InputHandler inputHandler = new InputHandler();

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void runGame() {
        int size = inputHandler.getBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        new BridgeGame().start(size, bridge);
    }
}
