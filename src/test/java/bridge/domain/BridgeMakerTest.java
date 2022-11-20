package bridge.domain;

import bridge.domain.generator.BridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

    @Test
    void makeBridge_case_1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "D", "D");
    }

    @Test
    void makeBridge_case_2() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "U", "D");
    }

    @Test
    void makeBridge_case_3() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "U");
    }

    @Test
    void makeBridge_case_4() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 0, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("D", "D", "D", "U", "U", "U");
    }

    @Test
    void makeBridge_case_5() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "D", "U", "D", "U");
    }
}