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
    private static final int RETRY_SELECT_CHAR_VALIDATE_NUMBER = 2;
    
    @DisplayName("이동할 칸 입력 : 정상 입력")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"U", "D"})
    void normalMovingInput(final String bridgeSize) {
        assertThatNoException()
                .isThrownBy(() -> InputSelectCharValidator.validate(bridgeSize, MOVING_SELECT_CHAR_VALIDATOR_NUMBER));
    }
    
    @DisplayName("이동할 칸 입력 예외 처리 : Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @NullAndEmptySource
    void nullOrEmptyMovingException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("이동할 칸 입력 예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {" ", "  ", " U", "U "})
    void spaceMovingException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("이동할 칸 입력 예외 처리 : 숫자 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"1", "-1", "0", "U1", "1U"})
    void numberMovingException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("이동할 칸 입력 예외 처리 : 특수 문자 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"@", "$", "%", ",", "."})
    void specialCharactersMovingException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("이동할 칸 입력 예외 처리 : 한글 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"ㄱ", "ㅏ", "가"})
    void koreanMovingException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("이동할 칸 입력 예외 처리 : U와 D가 아닌 영어 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"A", "C", "Q", "R", "T","a", "c", "u", "d", "r", "q"})
    void englishMovingException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("이동할 칸 입력 예외 처리 : 길이가 2이상인 경우")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @ValueSource(strings = {"UU", "DD", "UD" ,"DU", "UUU", "DDD"})
    void outOfLengthMovingException(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputSelectCharValidator.validate(input, MOVING_SELECT_CHAR_VALIDATOR_NUMBER))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("재시도 여부 입력 : 정상 입력")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"Q", "R"})
    void normalRetryInput(final String bridgeSize) {
        assertThatNoException()
                .isThrownBy(() -> InputSelectCharValidator.validate(bridgeSize, RETRY_SELECT_CHAR_VALIDATE_NUMBER));
    }
}