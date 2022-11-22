package bridge;

import static bridge.Validator.validateIsDigit;
import static bridge.Validator.validateIsMovingValue;
import static bridge.Validator.validateIsRetryValue;
import static bridge.Validator.validateSizeRange;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("다리 길이 사이즈가 범위를 벗어 날 때 경계값 예외테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {2, 21, 0, -10})
    void validateSizeRangeExceptionTest(int size) {
        assertThatThrownBy(() -> validateSizeRange(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 사이즈가 범위 내 일 때 경계값 통과테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {3, 20})
    void validateSizeRangePassTest(int size) {
        assertThatCode(() -> validateSizeRange(size)).doesNotThrowAnyException();
    }

    @DisplayName("다리 길이 입력 값이 숫자가 아닐 때 예외테스트")
    @ParameterizedTest
    @ValueSource(strings = {"삼3", "2two", "열개"})
    void validateIsDigitExceptionTest(String length) {
        assertThatThrownBy(() -> validateIsDigit(length))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 값이 숫자 일 때 통과테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3", "100", "0"})
    void validateIsDigitPassTest(String length) {
        assertThatCode(() -> validateIsDigit(length)).doesNotThrowAnyException();
    }

    @DisplayName("이동할 칸 입력값이 U, D 중 하나가 아닐 때 예외테스트")
    @ParameterizedTest
    @ValueSource(strings = {"u", "F", "위"})
    void validateIsMovingValueExceptionTest(String value) {
        assertThatThrownBy(() -> validateIsDigit(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력값이 U, D 중 하나 일 때 통과테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateIsMovingValuePassTest(String value) {
        assertThatCode(() -> validateIsMovingValue(value)).doesNotThrowAnyException();
    }

    @DisplayName("재시작 입력값이 Q, D 중 하나가 아닐 때 예외테스트")
    @ParameterizedTest
    @ValueSource(strings = {"q", "d", "재시작"})
    void validateIsRetryValueExceptionTest(String value) {
        assertThatThrownBy(() -> validateIsRetryValue(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}