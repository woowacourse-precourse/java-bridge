package bridge.Util;

import bridge.Constant.InputValue;

import bridge.Util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {
    @DisplayName("잘못된 위, 아래 입력 예외 throw")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bb", "d", "u", "", " "})
    void validateSelectionInput(String input) {
        assertThatThrownBy(() -> InputValidator.validateSelectionInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 위, 아래 입력 체크")
    @ParameterizedTest
    @ValueSource(strings = {InputValue.SELECTION_DOWN, InputValue.SELECTION_UP})
    void assignSelectionInput(String input) {
        assertDoesNotThrow(() -> InputValidator.validateSelectionInput(input));
    }

    @DisplayName("잘못된 재시작/종료 명령어 입력 예외 throw")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bb", "d1", "5", "", " ", "Q3", "3Q"})
    void validateCommandInput(String input) {
        assertThatThrownBy(() -> InputValidator.validateCommandInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("올바른 재시작/종료 명령어 체크")
    @ParameterizedTest
    @ValueSource(strings = {InputValue.COMMAND_QUIT, InputValue.COMMAND_RETRY})
    void assignCommandInput(String input) {
        assertDoesNotThrow(() -> InputValidator.validateCommandInput(input));
    }
}