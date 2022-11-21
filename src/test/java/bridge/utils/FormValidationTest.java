package bridge.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FormValidationTest {

    private final FormValidation formValidation = new FormValidation();

    @DisplayName("다리의 사이즈로 1~2자리의 숫자를 입력받지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"1a", "100", "a"})
    void validateBridgeSizeInputForm(String input) {
        Assertions.assertThatThrownBy(() -> formValidation.validateMovingInputForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸으로 U,D 이외에 다른 문자열를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"u", "d", "UU", "DD", "A", "1", "1U"})
    void validateMovingInputForm(String input) {
        Assertions.assertThatThrownBy(() -> formValidation.validateMovingInputForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateGameCommandInputForm() {
    }
}