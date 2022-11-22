package bridge;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @Test
    void 다리_만들기() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge.containsAll(Arrays.asList("U", "D"))).isEqualTo(true);
    }
}
