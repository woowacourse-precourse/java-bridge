package bridge.domain;

import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingTest {

    @DisplayName("이동 입력 값은 U또는 D여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validMovingTest(String input) {
        new Moving(input);
    }

    @DisplayName("이동 입력 값이 U또는 D가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q", "A", "", "*", " ", "/", "U ", "D "})
    void validMovingTestError(String input) {
        assertThatThrownBy(() -> new Moving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MOVING_VALUE.getMessage());
    }
}