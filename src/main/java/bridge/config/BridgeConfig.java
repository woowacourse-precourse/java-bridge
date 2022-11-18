package bridge.config;

import bridge.BridgeRandomNumberGenerator;

import bridge.domain.BridgeGame;
import bridge.generator.BridgeMaker;

public class BridgeConfig {

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public BridgeGame bridgeGame(int size) {
        BridgeMaker bridgeMaker = bridgeMaker();
        return new BridgeGame(bridgeMaker.makeBridge(size));
    }
    
}
