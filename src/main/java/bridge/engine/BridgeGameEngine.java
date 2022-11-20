package bridge.engine;

import bridge.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.BridgeSize;

public class BridgeGameEngine {

    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameEngine(BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }

    public Bridge makeBridge(int userInputSize) {
        BridgeSize bridgeSize = new BridgeSize(userInputSize);
        int size = bridgeSize.getValue();

        return new Bridge(bridgeMaker.makeBridge(size));
    }
}
