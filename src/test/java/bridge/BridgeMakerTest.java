package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator numberGenerator;

    @ParameterizedTest
    @MethodSource("generateTestBridge")
    @DisplayName("다리 생성 기능 테스트")
    void makeBridge(List<Integer> numbers, int size, List<String> expected) {
        numberGenerator = new NumberGeneratorTest(numbers);
        bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> actual = bridgeMaker.makeBridge(size);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateTestBridge() {
        return Stream.of(
                Arguments.of(newArrayList(0, 0, 0), 3, Arrays.asList("D", "D", "D")),
                Arguments.of(newArrayList(1, 1, 1, 1), 4, Arrays.asList("U", "U", "U", "U")),
                Arguments.of(newArrayList(1, 0, 1, 0, 1), 5, Arrays.asList("U", "D", "U", "D", "U"))
        );
    }

    static class NumberGeneratorTest implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        NumberGeneratorTest(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}