package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {-1234, -1, Round.ROUND_LOWER_BOUND - 1, Round.ROUND_UPPER_BOUND + 1, 1234})
    @DisplayName("[예외] 올바르지 않은 범위일시 예외 발생한다.")
    void isInvalidRoundRange(int number) {
        assertThatThrownBy(() -> Round.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.isInvalidRoundRange());
    }
}
