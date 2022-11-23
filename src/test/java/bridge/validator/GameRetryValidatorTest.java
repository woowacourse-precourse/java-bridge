package bridge.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameRetryValidatorTest {

    @DisplayName("Validate Game Retry Input has proper type")
    @ParameterizedTest
    @ValueSource(strings = {"U", "Retry"})
    void typeCheck(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            GameRetryValidator.typeCheck(input);
        });
    }

    @DisplayName("Validate Game Retry Input has proper type")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void typeCheckWithProperValue(String input) {
        assertDoesNotThrow(() -> GameRetryValidator.typeCheck(input));
    }
}