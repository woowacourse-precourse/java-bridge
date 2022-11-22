package bridge.utils.validators;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCommandValidatorTest {

    @DisplayName("공백에 대한 예외 처리")
    @Test
    void testBlank() {
        assertThatThrownBy(() -> new GameCommandValidator(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("대문자 Q 또는 대문자 R 이외의 값들에 대한 예외 처리")
    @ValueSource(strings = {"q", "r", "A", "B", "3", "$", "아", " "})
    @ParameterizedTest
    void testInput(String input) {
        assertThatThrownBy(() -> new GameCommandValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
