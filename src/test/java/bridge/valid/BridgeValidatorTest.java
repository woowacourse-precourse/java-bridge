package bridge.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeValidatorTest {

    @DisplayName("다리 길이가 3 미만이면 예외 발생")
    @Test
    void validateMinimumSize() {
        assertThatThrownBy(() -> BridgeValidator.validateSize(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3이상 20이하 이어야 합니다.");
    }

    @DisplayName("길이가 20 초과이면 예외 발생")
    @Test
    void validateMaximumSize() {
        assertThatThrownBy(() -> BridgeValidator.validateSize(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3이상 20이하 이어야 합니다.");
    }
}
