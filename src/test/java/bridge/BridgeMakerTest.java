package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void 다리_리스트_크기_확인() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3);
    }
}