package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @Test
    void 알맞은_크기의_다리를_생성하는가() {
        List<String> bridge = new BridgeMaker(bridgeNumberGenerator).makeBridge(10);
        Assertions.assertThat(bridge.size()).isEqualTo(10);
    }

}
