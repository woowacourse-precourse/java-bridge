package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 10})
    void makeBridgeSizeTest(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    void makeBridgeContainsTest(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(size)).containsAnyOf("U", "D");
    }
}
