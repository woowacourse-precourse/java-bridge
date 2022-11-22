package bridge.util.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UpDownValidatorTest {
    UpDownValidator udValidator;

    @BeforeEach
    void setUp() {
        udValidator = new UpDownValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"U", "D"})
    void 위_아래_입력_테스트(String input) {
        udValidator.validate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "A", "AB", "UD", "1"})
    void 위_아래_입력_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> udValidator.validate(input));
    }
}