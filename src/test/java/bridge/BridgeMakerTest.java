package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator1 = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker1 = new BridgeMaker(numberGenerator1);
        List<String> bridge1 = bridgeMaker1.makeBridge(3);
        assertThat(bridge1).containsExactly("U", "D", "D");

        BridgeNumberGenerator numberGenerator2 = new TestNumberGenerator(newArrayList(0, 1, 0));
        BridgeMaker bridgeMaker2 = new BridgeMaker(numberGenerator2);
        List<String> bridge2 = bridgeMaker2.makeBridge(3);
        assertThat(bridge2).containsExactly("D", "U", "D");
    }

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
}