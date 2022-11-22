package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.RepeatedTest;

class BridgeRandomNumberGeneratorTest {

    @RepeatedTest(50)
    void generate() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        assertThat(bridgeNumberGenerator.generate()).isBetween(0, 1);
    }
}