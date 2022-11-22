package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    public BridgeMakerTest() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void makeBridge() {
        int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println("bridge = " + bridge);
    }
}