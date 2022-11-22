package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리 생성 테스트 1")
    @Test
    void makeBridge1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertThat(bridge).containsExactly("U", "D", "U", "U");
    }

    @DisplayName("다리 생성 테스트 2")
    @Test
    void makeBridge2() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("D", "U", "U", "D", "D");
    }
}