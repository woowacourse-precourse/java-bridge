package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @DisplayName("숫자로만 이루어진 String 입력인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"123", "000"})
    void isAllDigit(String input) {
        assertTrue(ValidateInput.isAllDigit(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a12", "  1", "0 10"})
    void isAllDigitError(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.isAllDigit(input);
        });
    }

    @DisplayName("String 입력값이 3이상 20이하인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"12", "0004", "3", "20"})
    void isInRange(String input) {
        assertTrue(ValidateInput.isInRange(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "0400", "300", "21", "2"})
    void isInRangeError(String input){
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.isInRange(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void isUorD(String input) {
        assertTrue(ValidateInput.isUorD(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "0400", "a", "A", "UU", "DD"})
    void isUorDError(String input){
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.isUorD(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void isRorQ(String input) {
        assertTrue(ValidateInput.isRorQ(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "0400", "a", "A", "QQ", "RR"})
    void isRorQError(String input){
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.isRorQ(input);
        });
    }
}