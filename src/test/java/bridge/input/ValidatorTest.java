package bridge.input;

import bridge.input.message.Exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("3에서 20 사이의 숫자를 입력하면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @CsvSource({"3", "11", "20"})
    void 다리_갯수_검증_테스트(String bridgeSize) {
        assertThatCode(() -> Validator.bridgeSize(bridgeSize))
                .doesNotThrowAnyException();
    }

    @DisplayName("1글자나 2글자가 아닌 값이 들어오면 예외 처리한다.")
    @ParameterizedTest
    @CsvSource({"''", "abc", "1234"})
    void 글자수_예외_테스트(String bridgeSize) {
        assertThatThrownBy(() -> Validator.bridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.LENGTH.getMessage());
    }

    @DisplayName("첫번째 글자가 0으로 시작하면 예외 처리한다.")
    @ParameterizedTest
    @CsvSource({"0a", "01", "00"})
    void 첫번째_글자_예외_테스트(String bridgeSize) {
        assertThatThrownBy(() -> Validator.bridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.FIRST_LETTER.getMessage());
    }

    @DisplayName("숫자가 아닌 값이 있으면 예외 처리한다.")
    @ParameterizedTest
    @CsvSource({"a", "2+", "=3"})
    void 숫자_예외_테스트(String bridgeSize) {
        assertThatThrownBy(() -> Validator.bridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.NUMBER.getMessage());
    }

    @DisplayName("범위를 벗어나면 예외 처리한다.")
    @ParameterizedTest
    @CsvSource({"1", "2", "21"})
    void 범위_예외_테스트(String bridgeSize) {
        assertThatThrownBy(() -> Validator.bridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.RANGE.getMessage());
    }
}