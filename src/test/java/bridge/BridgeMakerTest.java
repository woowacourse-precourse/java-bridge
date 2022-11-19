package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @Test
    void 다리_생성_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size()).isEqualTo(3);
    }
}
