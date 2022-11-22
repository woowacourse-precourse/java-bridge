package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @Test
    void 다리만들기(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = 3;

        List<String> resultBridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println("resultBridge = " + resultBridge);
        assertThat(3).isEqualTo(resultBridge.size());
    }
}