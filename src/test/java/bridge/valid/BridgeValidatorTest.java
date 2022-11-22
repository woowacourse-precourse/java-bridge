package bridge.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeValidatorTest {

    @DisplayName("다리 길이가 3이상 20이하가 아니면 예외 발생")
    @ValueSource(ints = {2, 21})
    @ParameterizedTest
    void validateSizeRange(int size) {
        assertThatThrownBy(() -> BridgeValidator.validateSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3이상 20이하 이어야 합니다.");
    }
}
