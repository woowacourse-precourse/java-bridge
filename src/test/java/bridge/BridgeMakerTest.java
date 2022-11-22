package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = 3;
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge).contains("U", "D");
        assertThat(bridge).hasSize(bridgeSize);
    }
}