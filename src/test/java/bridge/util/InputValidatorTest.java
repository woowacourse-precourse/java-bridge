package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("다리 길이는 숫자이다.")
    @ParameterizedTest
    @CsvSource({"3,true", "17a,false", "aa,false"})
    void 다리_길이가_숫자인지_테스트(String number, Boolean expected) {
        assertThat(inputValidator.isNumber(number)).isEqualTo(expected);
    }
}