package bridge.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @DisplayName("다리 길이 입력 시 숫자를 입력하지 않으면 예외 처리한다.")
    @Test
    void inputNonNumeric() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3 이상 20 이하의 숫자를 입력하지 않으면 예외 처리한다.")
    @Test
    void inputInvalidRange() {
        assertThatThrownBy(() -> Validator.validateBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}