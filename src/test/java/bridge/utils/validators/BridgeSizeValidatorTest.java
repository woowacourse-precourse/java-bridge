package bridge.utils.validators;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeValidatorTest {

    @DisplayName("공백에 대한 예외 처리")
    @Test
    void testBlank() {
        assertThatThrownBy(() -> new GameCommandValidator(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3보다 작은 길이에 대한 예외 처리")
    @ValueSource(strings = {"-3", "0", "2"})
    @ParameterizedTest
    void testUnderSize(String input) {
        assertThatThrownBy(() -> new BridgeSizeValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20보다 큰 길이에 대한 예외 처리")
    @ValueSource(strings = {"21", "100", "5000"})
    @ParameterizedTest
    void testOverSize(String input) {
        assertThatThrownBy(() -> new BridgeSizeValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
