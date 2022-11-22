package bridge.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewValidatorTest {

    @DisplayName("입력 값이 숫자가 아니면 예외 발생")
    @Test
    void validate() {
        assertThatThrownBy(() -> InputViewValidator.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 숫자이어야 합니다.");
    }
}