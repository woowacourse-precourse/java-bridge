package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilTest {

    @DisplayName("문자열 입력값의 숫자 여부 거짓 테스트")
    @ValueSource(strings = {"a", "#", " "})
    @ParameterizedTest
    void isDigitFalse(String input) {
        boolean inputString = ValidationUtil.isDigit(input);
        assertThat(inputString).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "109", "2"})
    @DisplayName("문자열 입력값의 숫자 여부 참 테스트")
    void isDigitTrue(String input) {
        boolean inputString = ValidationUtil.isDigit(input);
        assertThat(inputString).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21})
    @DisplayName("다리 길이 입력값(int)의 허용 범위(3-20) 포함 여부 거짓 테스트")
    void isRangeFalse(int bridgeSizeInput) {
        int minNumber = 3;
        int maxNumber = 20;

        boolean isRange = ValidationUtil.isRange(bridgeSizeInput, minNumber, maxNumber);
        assertThat(isRange).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 20})
    @DisplayName("다리 길이 입력값(int)의 허용 범위(3-20) 포함 여부 참 테스트")
    void isRangeTrue(int bridgeSizeInput) {
        int minNumber = 3;
        int maxNumber = 20;

        boolean isRange = ValidationUtil.isRange(bridgeSizeInput, minNumber, maxNumber);
        assertThat(isRange).isTrue();
    }
}