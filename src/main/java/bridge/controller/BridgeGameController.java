package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.utils.InputHandler;
import java.util.List;

public class BridgeGameController {

    private final InputHandler inputHandler = new InputHandler();

    public void runGame(){
        int size = inputHandler.getBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        new BridgeGame().start(size, bridge);
    }
}
