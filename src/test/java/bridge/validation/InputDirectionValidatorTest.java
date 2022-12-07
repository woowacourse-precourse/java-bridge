package bridge.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputDirectionValidatorTest {

    @DisplayName("입력값이 'U' 혹은 'D'이 아닌 경우 예외를 반환한다.")
    @Test
    void validateInputDirectionTest() {
        Assertions.assertThatThrownBy(() -> InputDirectionValidator.validateInputDirection("UP"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동할 칸은 'U' 혹은 'D'로 입력해야 합니다.");
    }
}