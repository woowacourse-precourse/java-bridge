package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeGame;

public class Service {
    private BridgeGame bridgeGame;

    public void initBridgeGame(BridgeNumberGenerator generator, int size) throws IllegalArgumentException{
        final BridgeMaker bridgeMaker = new BridgeMaker(generator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
    }
}
