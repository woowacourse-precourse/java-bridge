package bridge.util;

import static bridge.util.Validator.*;
import static bridge.util.Validator.validateNumberInBridgeRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21, 22, 23})
    void validateNumberInBridgeRangeByOutOfRange(int number) {
        assertThatThrownBy(() -> validateNumberInBridgeRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void validateNumberInBridgeRangeByInRange(int number) {
        assertDoesNotThrow(() -> validateNumberInBridgeRange(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"d", "u", "a", "ua", "da", "", " "})
    void validateMovableInputByNotMovableInput(String input) {
        assertThatThrownBy(() -> validateMovableInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"D", "U"})
    void validateMovableInputByMovableInput(String input) {
        assertDoesNotThrow(() -> validateMovableInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "a", "ra", "qa", "", " "})
    void validateIfStringIsGameCommandByNotMatch(String string) {
        assertThatThrownBy(() -> validateIfStringIsGameCommand(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validateIfStringIsGameCommandByMatch(String string) {
        assertDoesNotThrow(() -> validateIfStringIsGameCommand(string));
    }
}