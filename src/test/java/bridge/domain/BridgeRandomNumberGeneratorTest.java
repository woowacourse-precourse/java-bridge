package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

class BridgeRandomNumberGeneratorTest {

    @RepeatedTest(50)
    void generate() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        assertThat(bridgeNumberGenerator.generate()).isBetween(0, 1);
    }
}