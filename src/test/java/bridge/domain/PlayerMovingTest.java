package bridge;

import bridge.domain.PlayerMoving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.utils.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerMovingTest {
    @ParameterizedTest
    @DisplayName("입력값이 U or D가 아니면 예외가 발생한다.")
    @ValueSource(strings = {" ", "u", "d", "1", "U1"})
    void createPlayerMovingByNotOptions(String input) {
        assertThatThrownBy(() -> new PlayerMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MOVING_NOT_OPTIONS);
    }
}
