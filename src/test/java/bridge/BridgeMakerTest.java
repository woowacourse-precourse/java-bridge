package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void 다리_만들기_테스트() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertThat(bridgeMaker.makeBridge(3)).containsAnyOf("U", "D");
    }
}