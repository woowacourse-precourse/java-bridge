package bridge.validator;

import bridge.common.SystemSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingValidatorTest {
    @ParameterizedTest
    @DisplayName("U, D가 아니라면 예외가 발생한다.")
    @ValueSource(strings = {"2", "d", "u", "@", "!!!", "예외"})
    public void 예외_입력_테스트(String input) {
        SystemSet.input(input);

        assertThatThrownBy(() -> MovingValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("올바른 형식을 입력받는다.")
    @ValueSource(strings = {"U", "D"})
    public void 올바른_입력_테스트(String input) {
        Assertions.assertThat(MovingValidator.validate(input)).isEqualTo(input);
    }
}
