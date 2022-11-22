package bridge.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MovingValidatorTest {
    @DisplayName("입력으로 들어온 게 U나 D가 아니라면 오류를 낸다")
    @ParameterizedTest
    @ValueSource(strings = {"X", "u", "d", " ", "", "1", "up", "down"})
    void validateWithInValidMoving(String input) {
        assertThatThrownBy(() -> MovingValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력으로 들어온 게 U나 D라면 오류 없다")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateWithValidMoving(String input) {
        assertThatCode(() -> MovingValidator.validate(input))
                .doesNotThrowAnyException();
    }
}
