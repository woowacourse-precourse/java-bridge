package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


class BridgeMakerTest {
    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 0, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(7);
        assertThat(bridge).containsExactly("U", "D", "D", "D", "D", "U", "U");
    }
}
