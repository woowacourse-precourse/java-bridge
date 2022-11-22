package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCommandValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new GameCommandValidator();
    }

    @DisplayName("대문자 R, Q가 아닌 값을 검증할 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"EXIT", "U", "D", "RETRY", "QUIT", "START"})
    void validateInvalidValue(String inputValue) {
        assertThatThrownBy(() -> validator.validate(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값 검증할 경우 예외가 발생한다.")
    @Test
    void validateBlankValue() {
        String blank = "";
        assertThatThrownBy(() -> validator.validate(blank))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소문자 r, q를 검증할 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"r", "q"})
    void validateLowercaseValue(String inputValue) {
        assertThatThrownBy(() -> validator.validate(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}