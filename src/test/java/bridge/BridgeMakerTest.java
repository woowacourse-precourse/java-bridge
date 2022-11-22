package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeNumberGenerator bridgeTestNumberGenerator = new BridgeTestNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeTestNumberGenerator);

    @Test
    void makeBridge() {
        for (int size = 3; size<=20; size++) {
            assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(size);
            assertThat(bridgeMaker.makeBridge(size)).contains("U").doesNotContain("D");
        }

    }
}