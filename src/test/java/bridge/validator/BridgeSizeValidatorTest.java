package bridge.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeSizeValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new BridgeSizeValidator();
    }

    @DisplayName("숫자가 아닌 값을 검증하면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"a", "가나다", "-10", "3!"})
    void validateNonNumericValue(String inputValue) {
        assertThatThrownBy(() -> validator.validate(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값을 검증하면 예외가 발생한다.")
    @Test
    void validateBlankValue() {
        String blank = "";
        assertThatThrownBy(() -> validator.validate(blank))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 유효하지 않은 값을 검증하면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "21", "100", "9999"})
    void validateInvalidBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> validator.validate(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}