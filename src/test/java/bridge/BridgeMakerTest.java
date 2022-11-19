package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("파라미터의 값만큼 다리가 생성되는지 테스트")
    @Test
    void createBridge() {
        int bridgeSize = 5;
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridges.size()).isSameAs(bridgeSize);
    }
}