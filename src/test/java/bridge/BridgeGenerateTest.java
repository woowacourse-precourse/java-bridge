package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.constant.ExceptionMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGenerateTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private static Stream<Arguments> bridgeGeneratingCorrectSource() {
        return Stream.of(
                Arguments.of(newArrayList(1, 0, 0), List.of("U", "D", "D")),
                Arguments.of(newArrayList(0, 0, 0, 0, 0, 0, 0), List.of("D", "D", "D", "D", "D", "D", "D")),
                Arguments.of(newArrayList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                        List.of("U", "U", "U", "U", "U", "U", "U", "U", "U", "U")),
                Arguments.of(newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1), List.of
                        ("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U"))
        );
    }

    private static Stream<Arguments> bridgeGeneratingExceptionSource() {
        return Stream.of(
                Arguments.of(newArrayList(1, 2, 2)),
                Arguments.of(newArrayList(0, 0, 0, 0, 3, 0, 0)),
                Arguments.of(newArrayList(1, 1, 1, 1, 1, 1, 1, 1, 1, -1)),
                Arguments.of(newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2147483647))
        );
    }

    private List<String> generateBridge(List<Integer> bridgeNumbers) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(bridgeNumbers);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker.makeBridge(bridgeNumbers.size());
    }

    @ParameterizedTest
    @DisplayName("다리가 제대로 생성되는 지 확인한다.")
    @MethodSource("bridgeGeneratingCorrectSource")
    void bridgeGeneratingCorrectTest(List<Integer> bridgeNumbers, List<String> bridgeAnswers) {
        assertThat(generateBridge(bridgeNumbers)).isEqualTo(bridgeAnswers);
    }

    @ParameterizedTest
    @DisplayName("다리 생성 숫자가 0, 1이 아닌 경우 Exception을 발생시킨다.")
    @MethodSource("bridgeGeneratingExceptionSource")
    void bridgeGeneratingExceptionTest(List<Integer> bridgeNumbers) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> generateBridge(bridgeNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_BRIDGE_NUMBER.getString()));
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
