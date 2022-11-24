package bridge.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    @DisplayName("다리 길이가 size와 같으면 성공")
    @Test
    void isBridgeSizeEqualToSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int testSize = 10;
        assertThat(bridgeMaker.makeBridge(testSize).size()).isEqualTo(testSize);
    }

}