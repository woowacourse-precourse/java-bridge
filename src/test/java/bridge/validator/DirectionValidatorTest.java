package bridge.validator;

import static bridge.validator.ErrorStatus.DIRECTION_SIGN_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DirectionValidatorTest {

    private final DirectionValidator directionValidator = new DirectionValidator();

    @DisplayName("문자열이 아닌 입력값에 대하여 예외를 반환한다.")
    @ValueSource(strings = {"3", "1.5", "-1"})
    @ParameterizedTest
    void isReturnExceptionWithInvalidTypeInput(String input) {
        assertThatThrownBy(() -> directionValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIRECTION_SIGN_ERROR.getMessage());

    }

    @DisplayName("U 혹은 D 가 아닌 문자열 입력값에 대하여 예외를 반환한다.")
    @ValueSource(strings = {"K", "-", "dddd"})
    @ParameterizedTest
    void isReturnExceptionWithInvalidSignInput(String input) {
        assertThatThrownBy(() -> directionValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIRECTION_SIGN_ERROR.getMessage());

    }

    @DisplayName("유효한 입력값에 대하여 아무런 예외가 발생하지 않고 유효성 검사가 통과한다.")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void isReturnNoExceptionWithValidInput(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> directionValidator.validate(input));

    }
}
