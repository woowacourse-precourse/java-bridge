package bridge.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void makeBridge() {
        final int size = 4;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> instance = bridgeMaker.makeBridge(size);

        boolean flag = false;
        for (int i = 0; i < instance.size(); i++) {
            if (!(instance.get(i).equals("U") || instance.get(i).equals("D"))) {
                flag = true;
            }
        }

        assertFalse(flag);
    }
}