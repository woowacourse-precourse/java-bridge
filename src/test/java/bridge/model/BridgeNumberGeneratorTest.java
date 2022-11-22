package bridge.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

class BridgeNumberGeneratorTest {

    @Test
    void generate() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int instance = bridgeNumberGenerator.generate();
        boolean flag = false;
        if (!(instance == 0 || instance == 1)) {
            flag = true;
        }
        assertFalse(flag);
    }
}