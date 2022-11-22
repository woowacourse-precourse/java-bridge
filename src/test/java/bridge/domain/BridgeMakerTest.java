package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @DisplayName("생성된 칸의 수는 다리 길이와 같다.")
    @Test
    void 칸의_수는_다리_길이와_같다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = 3;
        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(bridgeSize);
    }
}