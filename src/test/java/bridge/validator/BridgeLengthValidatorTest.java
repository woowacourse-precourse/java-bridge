package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ValidatorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeLengthValidatorTest {

    @DisplayName("자연수가 아니라면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.1", "안", "aaa"})
    void createNotNaturalNumber(String input) {
        assertThatThrownBy(() ->BridgeLengthValidator.validateNaturalNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorMessage.BRIDGE_LENGTH_MESSAGE.toString());

    }

    @DisplayName("3 이상 20 이하의 숫자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest()
    @ValueSource(strings = {"-1", "0", "21"})
    void createNumberOutOfRange(String input) {
        assertThatThrownBy(() ->BridgeLengthValidator.validateRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidatorMessage.BRIDGE_LENGTH_MESSAGE.toString());

    }
}