package bridge.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCommandValidatorTest {

    private final GameCommandValidator gameCommandValidator = new GameCommandValidator();

    @Test
    @DisplayName("문자열이 아닌 입력값에 대하여 예외를 반환한다.")
    void isReturnExceptionWithInvalidTypeInput() {
        //given
        String invalidTypeInput = "3";

        //when, then
        assertThatThrownBy(() -> gameCommandValidator.validate(invalidTypeInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("R 혹은 Q 가 아닌 문자열 입력값에 대하여 예외를 반환한다.")
    void isReturnExceptionWithInvalidSignInput() {
        //given
        String invalidSignInput = "K";

        //when, then
        assertThatThrownBy(() -> gameCommandValidator.validate(invalidSignInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효한 입력값에 대하여 아무런 예외가 발생하지 않고 유효성 검사가 통과한다.")
    void isReturnNoExceptionWithValidInput() {
        //given
        String validInput = "R";

        //when, then
        assertThatNoException().isThrownBy(() -> gameCommandValidator.validate(validInput));
    }
}
