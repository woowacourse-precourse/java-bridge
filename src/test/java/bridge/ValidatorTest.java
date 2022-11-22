package bridge;

import bridge.domain.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"e", "21", "1"})
    void validateNumericInputExceptionTest(String input) {
        assertThatThrownBy(() -> validator.validateNumericInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void validateNumericInputTest(String input) {
        assertEquals(Integer.valueOf(input),
                validator.validateNumericInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "u", "d"})
    void validateCharacterExceptionInput(String input) {
        List<String> indicators = List.of("U", "D");
        assertThatThrownBy(() -> validator.validateCharacterInput(input, indicators))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateCharacterInput(String input) {
        List<String> indicators = List.of("U", "D");
        assertEquals(input,
                validator.validateCharacterInput(input, indicators));
    }
}
