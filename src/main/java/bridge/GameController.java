package bridge;

import java.util.List;

public class GameController {

    public void start() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        bridgeMaker.makeBridge(bridgeNumberGenerator.generate());
    }
}
