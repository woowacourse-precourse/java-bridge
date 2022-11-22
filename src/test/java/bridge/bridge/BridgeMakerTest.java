package bridge.bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @Test
    public void makeBridgeTest() throws Exception {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        // when
        List<String> bridgeState = bridgeMaker.makeBridge(20);

        // then
        assertThat(bridgeState.size()).isEqualTo(20);
    }
}