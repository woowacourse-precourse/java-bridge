package bridge.validator;

import bridge.domain.game.Retry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RetryTest {

    @ParameterizedTest
    @DisplayName("R, Q")
    @ValueSource(strings = {"큐", "r", "q", "@", "!!", "2"})
    public void 예외_입력_테스트(String input) {
        assertThatThrownBy(() -> Retry.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("올바른 형식을 입력받는다.")
    @ValueSource(strings = {"R", "Q"})
    public void 올바른_입력_테스트(String input) {
        Assertions.assertThat(Retry.of(input)).isEqualTo(Retry.of(input));
    }
}
