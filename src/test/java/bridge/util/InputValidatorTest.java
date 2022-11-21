package bridge.util;

import static bridge.util.InputValidator.validateBridgeSize;
import static bridge.util.InputValidator.validateDigit;
import static bridge.util.InputValidator.validateMoving;
import static bridge.util.InputValidator.validateRetryOrExit;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.type.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("숫자가 아니면 에러가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1c", " ", ".", ","})
    void validateDigitTest(String input) {
        assertThatThrownBy(() -> validateDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.DIGIT_ERROR.printError());
    }

    @DisplayName("다리 이동은 U 혹은 D가 아니면 에러가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "u", " ", ".", ","})
    void validateMovingTest(String input) {
        assertThatThrownBy(() -> validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.MOVING_ERROR.printError());
    }

    @DisplayName("재시작 혹은 종료는 R 혹은 Q가 아니면 에러가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "u", " ", ".", ","})
    void validateRetryOrExitTest(String input) {
        assertThatThrownBy(() -> validateRetryOrExit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.COMMAND_ERROR.printError());
    }

    @DisplayName("다리 사이즈는 3~20이 아니면 에러가 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21, 25, 300})
    void validateBridgeSizeTest(int input) {
        assertThatThrownBy(() -> validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.BRIDGE_SIZE_ERROR.printError());
    }
}