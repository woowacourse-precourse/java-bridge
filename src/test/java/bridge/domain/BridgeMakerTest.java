package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    @Test
    void makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        System.out.println(bridge);
    }
}