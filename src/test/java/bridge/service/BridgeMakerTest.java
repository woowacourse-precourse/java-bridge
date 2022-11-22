package bridge.service;

import org.junit.jupiter.api.Test;
import utils.BridgeNumberGenerator;
import utils.BridgeRandomNumberGenerator;

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
