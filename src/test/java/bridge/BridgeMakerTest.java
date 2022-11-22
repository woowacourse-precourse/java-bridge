package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void 다리_길이_확인() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(10).size()).isEqualTo(10);
    }
}