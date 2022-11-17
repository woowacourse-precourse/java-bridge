package bridge.domain.validation;

import static bridge.domain.validation.InputValidator.INPUT_ONLY_NUMBERS;
import static bridge.domain.validation.InputValidator.NOT_VALID_MOVE_COMMANDS;
import static bridge.domain.validation.InputValidator.NOT_VALID_RANGE_OF_BRIDGE_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest(name = "숫자가 아닌 값을 입력하면 예외가 발생한다. 입력: {0}")
    @ValueSource(strings = {"하하", "hoho", " ", "1234a"})
    void validateThisIsNumber(String inputValue) {
        assertThatThrownBy(() -> InputValidator.validateThisIsNumber(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_ONLY_NUMBERS);
    }

    @ParameterizedTest(name = "다리 길이 범위를 벗어나는 값을 입력하면 예외가 발생한다. 입력: {0}")
    @ValueSource(ints = {0, 2, 25, 30})
    void validateBridgeSize(int inputValue) {
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_VALID_RANGE_OF_BRIDGE_SIZE);
    }

    @ParameterizedTest(name = "U, D가 아닌 값을 입력하면 예외가 발생한다. 입력: {0}")
    @ValueSource(strings = {"R", "Q", "ddd", "1"})
    void validateCorrectValueForMoving(String inputValue) {
        assertThatThrownBy(() -> InputValidator.validateCorrectValueForMoving(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_VALID_MOVE_COMMANDS);
    }
}