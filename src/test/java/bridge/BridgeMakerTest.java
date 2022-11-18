package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void 다리생성시_D_변환_테스트() {
        BridgeNumberGenerator bridgeNumberGenerator = new NumberZeroGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(1);
        assertThat(bridge).containsExactly("D");
    }
    @Test
    void 다리생성시_U_변환_테스트() {
        BridgeNumberGenerator bridgeNumberGenerator = new NumberOneGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(1);
        assertThat(bridge).containsExactly("U");
    }
    static class NumberZeroGenerator implements BridgeNumberGenerator {
        @Override
        public int generate() {
            return 0;
        }
    }
    static class NumberOneGenerator implements BridgeNumberGenerator {
        @Override
        public int generate() {
            return 1;
        }
    }
}