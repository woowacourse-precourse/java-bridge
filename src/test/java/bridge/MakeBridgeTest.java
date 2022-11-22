package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class MakeBridgeTest {
    @Test
    void makeBridge_3_MIN_SIZE() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void makeBridge_12_MEDIUM_SIZE() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(12);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "D", "U", "D", "D", "U", "U", "U");
    }

    @Test
    void makeBridge_20_MAX_SIZE() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "D", "U", "D", "D", "U", "U", "U", "U", "D", "D", "U", "D", "D", "U", "D");
    }
}
