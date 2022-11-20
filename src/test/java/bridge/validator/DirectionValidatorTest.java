package bridge.validator;

import static bridge.validator.ErrorStatus.DIRECTION_SIGN_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionValidatorTest {

    private final DirectionValidator directionValidator = new DirectionValidator();

    @Test
    @DisplayName("문자열이 아닌 입력값에 대하여 예외를 반환한다.")
    void isReturnExceptionWithInvalidTypeInput() {
        //given
        String invalidTypeInput = "3";

        //when, then
        assertThatThrownBy(() -> directionValidator.validate(invalidTypeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIRECTION_SIGN_ERROR.getMessage());

    }

    @Test
    @DisplayName("U 혹은 D 가 아닌 문자열 입력값에 대하여 예외를 반환한다.")
    void isReturnExceptionWithInvalidSignInput() {
        //given
        String invalidSignInput = "F";

        //when, then
        assertThatThrownBy(() -> directionValidator.validate(invalidSignInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIRECTION_SIGN_ERROR.getMessage());

    }

    @Test
    @DisplayName("유효한 입력값에 대하여 아무런 예외가 발생하지 않고 유효성 검사가 통과한다.")
    void isReturnNoExceptionWithValidInput() {
        //given
        String validInput = "D";

        //when, then
        Assertions.assertThatNoException().isThrownBy(() -> directionValidator.validate(validInput));

    }
}
