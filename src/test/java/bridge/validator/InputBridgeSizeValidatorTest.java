package bridge.validator;

import bridge.constant.ErrorMessageConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputBridgeSizeValidatorTest {
    @DisplayName("정상 입력")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"3", "9", "10", "11", "19", "20"})
    void normalInput(final String input) {
        assertThatNoException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(input));
    }
    
    @DisplayName("예외 처리 : Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @NullAndEmptySource
    void nullOrEmptyException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {" ", "  ", "3 ", " 3"})
    void spaceException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 3~20 범위를 벗어난 숫자 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"-1", "0", "2", "21", "30", "31", "40", "200", "201"})
    void outOfRangeException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 특수 문자 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"$", "@", ",", ".", ":"})
    void specialCharactersException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(input))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}