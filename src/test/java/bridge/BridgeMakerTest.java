package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트_3() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "U", "U");
    }

    @Test
    void 다리_생성_테스트_12() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(12);
        assertThat(bridge).containsExactly("D", "U", "U", "U", "D", "D", "U", "D", "D", "U", "D", "U");
    }

    @Test
    void 다리_생성_테스트_20() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsExactly("D", "D", "D", "D", "D", "D", "U", "U", "U", "U", "U", "U", "U", "D", "D", "U", "U", "U", "U", "U");
    }
}