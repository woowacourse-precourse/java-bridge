package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("makeBridge 메소드 테스트1")
    @Test
    void makeBridgeMethodTest1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThat(bridgeMaker.makeBridge(3)).isEqualTo(List.of("D", "U", "U"));
    }

    @DisplayName("makeBridge 메소드 테스트2")
    @Test
    void makeBridgeMethodTest2() {
        BridgeNumberGenerator numberGenerator
                = new TestNumberGenerator(newArrayList(0, 1, 1, 0, 1, 1, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThat(bridgeMaker.makeBridge(9))
                .isEqualTo(List.of("D", "U", "U", "D", "U", "U", "D", "U", "D"));
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