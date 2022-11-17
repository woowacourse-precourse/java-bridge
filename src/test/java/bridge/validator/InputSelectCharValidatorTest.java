package bridge.validator;

import bridge.constant.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputSelectCharValidatorTest {
    private static final int MOVING_SELECT_CHAR_VALIDATOR_NUMBER = 1;
    
    @DisplayName("정상 입력")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"U", "D"})
    void normalInput(final String bridgeSize) {
        assertThatNoException()
                .isThrownBy(() -> InputSelectCharValidator.validate(bridgeSize, MOVING_SELECT_CHAR_VALIDATOR_NUMBER));
    }
    
    @DisplayName("예외 처리 : Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @NullAndEmptySource
    void nullOrEmptyException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {" ", "  ", " U", "U "})
    void spaceException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 숫자 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"1", "-1", "0", "U1", "1U"})
    void numberException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 특수 문자 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"@", "$", "%", ",", "."})
    void specialCharactersException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}