package bridge.domain;

import static bridge.domain.BridgeSize.NOT_VALID_RANGE_OF_BRIDGE_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @ParameterizedTest(name = "다리 길이 범위를 벗어나는 값을 입력하면 예외가 발생한다. 입력: {0}")
    @ValueSource(ints = {0, 2, 25, 30})
    void validateBridgeSize(int inputValue) {
        assertThatThrownBy(() -> new BridgeSize(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_VALID_RANGE_OF_BRIDGE_SIZE);
    }
}