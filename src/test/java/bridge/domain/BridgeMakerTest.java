package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    @Test
    void makeTest() {
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(newArrayList(1, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertThat(bridge).isEqualTo(List.of("U", "D", "U", "D"));
    }

    @DisplayName("다리 길이가 3 미만, 20 초과 경우에 대한 예외 처리")
    @ValueSource(ints = {-100, -1, 0, 1, 2, 21, 30, 100, 1000})
    @ParameterizedTest
    void outOfRangeBridgeLength(Integer input) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(input))
                .isInstanceOf(IllegalArgumentException.class);
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