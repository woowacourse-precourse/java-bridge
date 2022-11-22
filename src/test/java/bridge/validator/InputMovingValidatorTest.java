package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputMovingValidatorTest {

    @DisplayName("사용자가 이동할 칸을 입력할 때 U와 D 이외의 문자열을 입력할 경우 예외가 발생한다.")
    @ValueSource(strings = {"A", "B", "1", " ", "UD", "DDD"})
    @ParameterizedTest
    void validateInvalidMovingInput(String input) {
        assertThatThrownBy(() -> InputMovingValidator.validateMovingInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}