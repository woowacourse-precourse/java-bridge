package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeValidatorTest {

    @DisplayName("3이상 20이하의 다리 길이가 아니면 예외를 반환한다.")
    @ValueSource(ints = {0, 1, 2, 21, 30, 55})
    @ParameterizedTest
    void validateWrongBridgeSize(int bridgeSize) {
        assertThatThrownBy(() -> BridgeValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다.");
    }
}