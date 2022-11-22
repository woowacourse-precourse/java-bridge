package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BridgeMaker 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeMakerTest {

    @ParameterizedTest
    @MethodSource("makeBridgeTestArgumentProvider")
    void makeBridge_메서드는_다리의_길이를_입력받아_U와_D로_표현된_다리를_반환한다(List<Integer> number, int size, String[] strings) {
        BridgeNumberGenerator numberGenerator = new TestBridgeNumberGenerator(number);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        List<String> result = bridgeMaker.makeBridge(size);
        assertThat(result).containsExactly(strings);
    }

    static List<Arguments> makeBridgeTestArgumentProvider() {
        return Arrays.asList(
                Arguments.of(newArrayList(1, 0, 1), 3, new String[]{"U", "D", "U"}),
                Arguments.of(newArrayList(0, 0, 0, 0), 4, new String[]{"D", "D", "D", "D"}),
                Arguments.of(newArrayList(0, 0, 1, 0, 0), 5, new String[]{"D", "D", "U", "D", "D"}),
                Arguments.of(newArrayList(1, 1, 1, 1, 1), 5, new String[]{"U", "U", "U", "U", "U"})
        );
    }

    static class TestBridgeNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestBridgeNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
