package bridge.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ValidatorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberOfTryValidatorTest {

    @DisplayName("2,100,000,000번 이상 게임을 시도하면 예외를 발생한다.")
    @ParameterizedTest()
    @ValueSource(strings = {"2100000000", "2147483647"})
    void createNumberOutOfRange(int input) {
        assertThatThrownBy(() -> NumberOfTryValidator.validateNumberOfTry(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorMessage.TOO_MUCH_GAME.toString());
    }

    @DisplayName("2,100,000,000번 이하의 시도라면 예외가 발생하지 않는다.")
    @ParameterizedTest()
    @ValueSource(strings = {"0", "2099999999"})
    void createNormalTryCount(int input) {
        assertThatCode(() -> NumberOfTryValidator.validateNumberOfTry(input))
                .doesNotThrowAnyException();
    }
}