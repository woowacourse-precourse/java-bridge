package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ValidatorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountValidatorTest {

    @DisplayName("2,100,000,000번 이상 게임을 시도하면 예외를 발생한다.")
    @ParameterizedTest()
    @ValueSource(strings = {"2100000001", "2147483647"})
    void createNumberOutOfRange(int input) {
        assertThatThrownBy(() ->TryCountValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorMessage.TOO_MUCH_GAME.toString());

    }
}