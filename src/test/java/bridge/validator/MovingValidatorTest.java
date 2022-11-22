package bridge.validator;

import static bridge.validator.MovingValidator.validateMoving;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.WrongMovingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingValidatorTest {

    @DisplayName("이동할 칸은 U또는 D이다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void movingMustBeUorD(String input) {
        validateMoving(input);
    }

    @DisplayName("이동할 칸이 U나 D가 아닐경우 예외 처리한다.")
    @ValueSource(strings = {"A", "B", "-U", "", " "})
    @ParameterizedTest
    void exceptWhenMovingNotUorD(String input) {
        assertThatThrownBy(() -> validateMoving(input))
                .isInstanceOf(WrongMovingException.class);
    }
}