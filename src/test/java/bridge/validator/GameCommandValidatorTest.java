package bridge.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCommandValidatorTest {

    private final GameCommandValidator gameCommandValidator = new GameCommandValidator();

    @DisplayName("문자열이 아닌 입력값에 대하여 예외를 반환한다.")
    @ValueSource(strings = {"3", "1.5", "-1"})
    @ParameterizedTest
    void isReturnExceptionWithInvalidTypeInput(String input) {
        assertThatThrownBy(() -> gameCommandValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R 혹은 Q 가 아닌 문자열 입력값에 대하여 예외를 반환한다.")
    @ValueSource(strings = {"k", "K", "M"})
    @ParameterizedTest
    void isReturnExceptionWithInvalidSignInput(String input) {
        assertThatThrownBy(() -> gameCommandValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소문자인 r 혹은 q 에 대하여 예외를 반환한다.")
    @ValueSource(strings = {"r", "q"})
    @ParameterizedTest
    void isReturnExceptionWithSmallLetterInput(String input) {
        assertThatThrownBy(() -> gameCommandValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 입력값에 대하여 아무런 예외가 발생하지 않고 유효성 검사가 통과한다.")
    @ValueSource(strings = {"R", "Q"})
    void isReturnNoExceptionWithValidInput(String input) {
        assertThatNoException().isThrownBy(() -> gameCommandValidator.validate(input));
    }
}
