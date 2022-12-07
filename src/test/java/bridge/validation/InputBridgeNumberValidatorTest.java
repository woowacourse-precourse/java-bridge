package bridge.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputBridgeNumberValidatorTest {

    @DisplayName("입력값이 숫자가 아닌 경우 예외를 반환한다.")
    @Test
    void validateInputNumberTest() {
        Assertions.assertThatThrownBy(() -> InputBridgeNumberValidator.validateInputBridgeNumber("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 숫자여야 합니다.");
    }

    @DisplayName("입력값이 3부터 20까지의 숫자가 아닌 경우 예외를 반환한다.")
    @Test
    void validateBridgeSizeTest() {
        Assertions.assertThatThrownBy(() -> InputBridgeNumberValidator.validateBridgeSize(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}