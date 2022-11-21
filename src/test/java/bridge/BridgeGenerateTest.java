package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGenerateTest extends NsTest {
    private static Stream<Arguments> bridgeGeneratingCorrectSource() {
        return Stream.of(
                Arguments.of(newArrayList(1, 0, 0), 3, List.of("U", "D", "D")),
                Arguments.of(newArrayList(0, 0, 0, 0, 0, 0, 0), 7, List.of("D", "D", "D", "D", "D", "D", "D")),
                Arguments.of(newArrayList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 10,
                        List.of("U", "U", "U", "U", "U", "U", "U", "U", "U", "U")),
                Arguments.of(newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0), 20,
                        List.of("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U",
                                "D", "U", "D"))
        );
    }

    @ParameterizedTest
    @DisplayName("다리가 제대로 생성되는 지 확인한다.")
    @MethodSource("bridgeGeneratingCorrectSource")
    void bridgeGeneratingCorrectTest(List<Integer> bridgeNumbers, int size, List<String> bridgeAnswers) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(bridgeNumbers);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge).isEqualTo(bridgeAnswers);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
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
