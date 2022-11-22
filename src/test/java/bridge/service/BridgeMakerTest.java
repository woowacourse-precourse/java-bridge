package bridge.service;

import bridge.BridgeMaker;
import org.junit.jupiter.api.Test;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeMakerTest {

    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int size = 3;

        List<String> actual = bridgeMaker.makeBridge(size);
        System.out.println(actual);
    }
}
