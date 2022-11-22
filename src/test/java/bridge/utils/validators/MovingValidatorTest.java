package bridge.utils.validators;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MovingValidatorTest {

    @DisplayName("공백에 대한 예외 처리")
    @Test
    void testBlank() {
        assertThatThrownBy(() -> new MovingValidator(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("대문자 U 또는 대문자 D 이외의 값들에 대한 예외 처리")
    @ValueSource(strings = {"u", "d", "A", "B", "3", "$", "아", " "})
    @ParameterizedTest
    void testInput(String input) {
        assertThatThrownBy(() -> new MovingValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
