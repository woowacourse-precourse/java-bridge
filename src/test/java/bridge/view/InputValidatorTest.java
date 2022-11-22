package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InputValidatorTest {


    @DisplayName("숫자가 아닐 경우 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "#", "_"})
    void validateNumber(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputValidator.validateNumber(input);
                });
    }

    @DisplayName("다리의 길이가 3~20 아닐 경우 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 21})
    void validateBridgeSize(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputValidator.validateBridgeSize(input);
                });
    }
}
