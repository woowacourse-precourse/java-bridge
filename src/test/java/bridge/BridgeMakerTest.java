package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @DisplayName("입력된 다리 길이에 따라 다리를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideBridgeExample")
    void makeBridge(Integer bridgeLength, List<Integer> bridgeNumbers, String[] blockSymbols) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(bridgeNumbers);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        assertThat(bridge).containsExactly(blockSymbols);
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

    private static Stream<Arguments> provideBridgeExample() {
        return Stream.of(
                Arguments.of(3, newArrayList(1, 0, 0), new String[] {"U", "D", "D"}),
                Arguments.of(3, newArrayList(0, 1, 1), new String[] {"D", "U", "U"}),
                Arguments.of(4, newArrayList(1, 0, 0, 1), new String[] {"U", "D", "D", "U"}),
                Arguments.of(5, newArrayList(0, 1, 0, 1, 0), new String[] {"D", "U", "D", "U", "D"})
        );
    }

}