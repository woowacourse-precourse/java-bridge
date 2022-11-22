package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @Test
    void makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge.size()).isEqualTo(5);
    }
}