package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("다리 길이 입력값은 숫자이다.")
    @ParameterizedTest
    @CsvSource({"3,true", "17a,false", "aa,false"})
    void 다리_길이_입력값이_숫자인지_테스트(String number, Boolean expected) {
        assertThat(inputValidator.isNumber(number)).isEqualTo(expected);
    }

    @DisplayName("다리 길이 입력값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "12a", "_+2"})
    void 다리_길이_입력값_예외처리(String bridgeSize) {
        assertThatThrownBy(() -> inputValidator.validateNumber(bridgeSize)).isInstanceOf(
                IllegalArgumentException.class);
    }
}