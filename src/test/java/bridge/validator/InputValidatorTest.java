package bridge.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    InputValidator inputValidator;

    @BeforeEach
    void init() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"123f", "김현우", "fda"})
    @DisplayName("숫자가 아닐 경우 IllegalArgumentException를 반환합니다.")
    void testIsDigit_IllegalArgumentException(String input) throws Exception {

        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> inputValidator.isDigit(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"124", "1", "651"})
    @DisplayName("숫자일 경우 아무것도 반환하지 않습니다.")
    void testIsDigit_success(String input) throws Exception {
        //when & then
        inputValidator.isDigit(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"24", "42", "20000"})
    @DisplayName("3이상 20이하의 숫자가 아닐 경우 IllegalArgumentException을 반환합니다.")
    void testIsInBoundary_IllegalArgumentException(String input) throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> inputValidator.isInBoundary(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"3", "20", "15"})
    @DisplayName("3이상 20이하의 숫자일 경우 아무것도 반환하지 않습니다.")
    void testIsInBoundary_success(String input) throws Exception {
        //when & then
        inputValidator.isInBoundary(input);
    }
}