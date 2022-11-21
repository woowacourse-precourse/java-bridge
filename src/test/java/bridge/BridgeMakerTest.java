package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @DisplayName("다리의 크기가 주어지고, 1만 주어질 때 U로만 이루어진 다리를 반환")
    @Test
    void makeBridgeGiveOne() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);
        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("U", "U", "U", "U", "U", "U");
    }

    @DisplayName("다리의 크기가 주어지고, 0만 주어질 때 D로만 이루어진 다리를 반환")
    @Test
    void makeBridgeGiveZero() {
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);
        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("D", "D", "D", "D", "D", "D");
    }

    @DisplayName("1, 0이 주어질 때 D, U로 이루어진 다리를 반환")
    @Test
    void makeBridge() {
        BridgeNumberGenerator generator = new TestBridgeNumberGenerator(newArrayList(1, 0, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "U");
    }
}
