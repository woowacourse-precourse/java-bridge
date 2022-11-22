package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @DisplayName("다리 생성길이 확인")
    @Test
    void makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        assertThat(bridgeMaker.makeBridge(10).size()).isEqualTo(10);
    }
}