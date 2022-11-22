package bridge.domain;

import bridge.BridgeNumberGenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

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

    @ParameterizedTest
    @MethodSource("makeBridgeTestData")
    void makeBridgeTest(List<Integer> geneartedNumber, int bridgeSize, List<String> answer) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(geneartedNumber));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge).isEqualTo(answer);
    }

    static Stream<Arguments> makeBridgeTestData() {
        return Stream.of(
                Arguments.of(List.of(0, 0, 0), 3, List.of("D", "D", "D")),
                Arguments.of(List.of(0, 1, 0), 3, List.of("D", "U", "D")),
                Arguments.of(List.of(1, 0, 1), 3, List.of("U", "D", "U")),
                Arguments.of(List.of(1, 0, 1, 0, 1), 5, List.of("U", "D", "U", "D", "U")),
                Arguments.of(List.of(0, 0, 0, 1, 1, 1), 6, List.of("D", "D", "D", "U", "U", "U"))
        );
    }
}