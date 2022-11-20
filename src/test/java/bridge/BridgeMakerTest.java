package bridge;

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
    @DisplayName("다리 길이 입력값이 3~20 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 21, 2})
    void makeBridgeByOutOfRange(int bridgeSize) {
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OUT_OF_RANGE);
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
