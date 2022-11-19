package global.advice;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("입력되지 않거나, 두자리 초과하여 입력하면 예외가 발생한다.")
    @ParameterizedTest(name = "입력 : {0}")
    @ValueSource(strings = {"", "100", "14444"})
    void checkLength(String size) {
        assertThatThrownBy(() -> InputValidator.checkLength(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 이외에 문자가 입력되면 예외가 발생한다.")
    @ParameterizedTest(name = "입력 : {0}")
    @ValueSource(strings = {".", "@", " ", "  ", "%", "B", "ㅎ", ";", "+" ,"-10"})
    void checkIsDigit(String size) {
        assertThatThrownBy(() -> InputValidator.checkIsDigit(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사이즈가 숫자 범위내에 있지 않으면 예외가 발생한다.")
    @ParameterizedTest(name = "입력 : {0}")
    @ValueSource(strings = {"0","1", "2", "21", "99" ,"-10"})
    void checkRange(String size) {
        assertThatThrownBy(() -> InputValidator.checkRange(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

}