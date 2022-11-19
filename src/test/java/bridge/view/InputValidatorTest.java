package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @DisplayName("문자에서 숫자로 바뀌는지 확인")
    @Test
    void checkConvertInputToInt() {
        String input = "123";
        assertThatCode(() -> InputValidator.changeInputToInt(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("문자에서 숫자로 바꿀 수 없는 경우 예외 처리")
    @Test
    void checkConvertInputToIntByNoneDigit() {
        String input = "abc";
        assertThatThrownBy(() -> InputValidator.changeInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수형의 숫자가 아닙니다.");
    }

    @DisplayName("다리의 길이가 3~20의 숫자이면 정상 작동")
    @Test
    void validateBridgeSizeOfSuccessCase() {
        int size = 10;
        assertThatCode(() -> InputValidator.validateBridgeSize(size))
                .doesNotThrowAnyException();
    }

    @DisplayName("다리의 길이가 3~20의 숫자가 아니면 예외 처리")
    @Test
    void validateBridgeSizeOfExceptionCase() {
        int size = 30;
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
