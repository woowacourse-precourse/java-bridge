package bridge.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputGameOptionValidatorTest {

    @DisplayName("입력값이 'R' 혹은 'Q'이 아닌 경우 예외를 반환한다.")
    @Test
    void validateInputGameOptionTest () {
        Assertions.assertThatThrownBy(() -> InputGameOptionValidator.validateInputGameOption("RESTART"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("재시도는 'R', 종료는 'Q'로 입력해야 합니다.");
    }
}