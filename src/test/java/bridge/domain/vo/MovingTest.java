package bridge.domain.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.constants.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingTest {

    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"U", "D"})
    void Normal_Test(String input) {
        Assertions.assertThat(Moving.from(input).equals(input)).isTrue();
    }

    @DisplayName("Unvalidated GameMoving")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"a", "1", "u", "r", "d", "@"})
    void Unvalidated_GameMoving_exception(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Moving.from(input);
        });
        assertEquals(ErrorCode.MOVING_NOT_U_D.getException().getMessage(),
                exception.getMessage());
    }
}