package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트1() {
        BridgeNumberGenerator bridgeNumberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "U", "D");
    }

    @Test
    void 다리_생성_테스트2() {
        BridgeNumberGenerator bridgeNumberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "U", "U", "D", "D");
    }
}