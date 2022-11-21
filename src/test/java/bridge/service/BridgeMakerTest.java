package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {
    @Test
    void 다리만들기(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = 3;

        List<String> resultBridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println("resultBridge = " + resultBridge);
    }
}