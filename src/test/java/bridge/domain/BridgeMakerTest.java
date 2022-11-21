package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.utils.ErrorMessages.ERROR_INVALID_BRIDGE_NUMBER;
import static bridge.utils.ErrorMessages.ERROR_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BridgeMakerTest {
    @DisplayName("다리 생성 랜덤값이 1 또는 0이 아닌 경우 예외가 발생한다.")
    @Test
    void makeBridgeByInValidRandomNumbers() {
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(0, 1, 2));
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_INVALID_BRIDGE_NUMBER);
    }

    @DisplayName("입력받은 길이의 다리를 생성한다.")
    @ParameterizedTest
    @MethodSource("generateMakeBridgeTestData")
    void makeBridge(List<Integer> bridgeNumbers, int bridgeSize, List<String> expectedBridge) {
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(bridgeNumbers);
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge)
            .usingRecursiveComparison()
            .isEqualTo(expectedBridge);
    }

    static Stream<Arguments> generateMakeBridgeTestData() {
        return Stream.of(
                arguments(newArrayList(0, 0, 1), "3",
                        List.of("D", "D", "U")),
                arguments(newArrayList(1, 1, 0, 0, 1, 1, 0, 0, 0, 0), "10",
                        List.of("U", "U", "D", "D", "U", "U", "D", "D", "D", "D"))
        );
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator() {
            this.numbers = newArrayList(0, 1, 1);
        }

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
