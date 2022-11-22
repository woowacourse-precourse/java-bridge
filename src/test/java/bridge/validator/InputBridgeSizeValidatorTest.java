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
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"3", "9", "10", "11", "19", "20"})
    void normalInput(final String bridgeSize) {
        assertThatNoException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize));
    }
    
    @DisplayName("예외 처리 : Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @NullAndEmptySource
    void nullOrEmptyException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 공백 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {" ", "  ", "3 ", " 3"})
    void spaceException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 3~20 범위를 벗어난 숫자 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"-1", "0", "2", "21", "30", "31", "40", "200", "201"})
    void outOfRangeException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 특수 문자 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"$", "@", ",", ".", ":"})
    void specialCharactersException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 한글 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"ㄱ", "ㅏ", "가"})
    void koreanException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 영어 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"a", "A", "z", "Z"})
    void englishException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 3자리 이상 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"123", "123456789", "1234567890", "123456789012345678901234567890", "2020", "202", "100"})
    void outOfLengthException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 2자리일 때, 첫번째 자리에 0이 오는 경우")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"00", "01", "02", "03", "04"})
    void zeroAtFirstPlaceExistException(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize))
                .withMessageStartingWith(ErrorMessageConstant.ERROR_MESSAGE);
    }
}