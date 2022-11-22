package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class BridgeMakerTest {

    @DisplayName("3 이상 20 이하 길이를 가진 다리 생성")
    @ParameterizedTest
    @MethodSource("generateArgumentStreamOfSuccessCase")
    void makeBridgeWithValidNumbers(List<Integer> bridgeNumbers, String... expected) {
        BridgeMaker bridgeMaker = createBridgeMakerWithTestNumbers(bridgeNumbers);

        assertThat(bridgeMaker.makeBridge(bridgeNumbers.size()))
                .containsExactly(expected);
    }

    private static Stream<Arguments> generateArgumentStreamOfSuccessCase() {
        List<Arguments> arguments = new LinkedList<>();
        arguments.add(Arguments.of(newArrayList(1, 0, 0), new String[]{"U", "D", "D"}));
        arguments.add(Arguments.of(
                newArrayList(0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0),
                new String[]{"D", "U", "D", "U", "D", "D", "U", "D", "U", "D",
                            "D", "U", "D", "U", "D", "D", "U", "D", "U", "D"}
        ));
        return arguments.stream();
    }

    @DisplayName("일치하는 다리 칸 정보가 없는 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("generateStreamOfInvalidNumbers")
    void makeBridgeWithInvalidNumbers(List<Integer> bridgeNumbers) {
        BridgeMaker bridgeMaker = createBridgeMakerWithTestNumbers(bridgeNumbers);

        assertThatThrownBy(() -> bridgeMaker.makeBridge(3)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> generateStreamOfInvalidNumbers() {
        List<List<Integer>> invalidNumbers = new LinkedList<>();
        invalidNumbers.add(newArrayList(2, 0, 0));
        invalidNumbers.add(newArrayList(0, 2, 0));
        invalidNumbers.add(newArrayList(0, 0, 2));
        return invalidNumbers.stream();
    }

    @DisplayName("범위 밖의 길이로 다리 생성 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 21})
    void makeBridgeWithOverSize(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeSize)).isInstanceOf(IllegalArgumentException.class);
    }

    private BridgeMaker createBridgeMakerWithTestNumbers(List<Integer> bridgeNumbers) {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(bridgeNumbers);
        return new BridgeMaker(bridgeNumberGenerator);
    }

    private static class TestNumberGenerator implements BridgeNumberGenerator {

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