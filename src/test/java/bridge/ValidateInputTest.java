package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {
    @DisplayName("다리의 길이가 올바른 값이 아니면 예외가 발생한다.")
    @ValueSource(strings = {"999", "0", "-123", "21", "-1", "10j", " 1", "20 "})
    @ParameterizedTest
    void testBridgeSize(String input) {
        assertThatThrownBy(() -> ValidateInput.bridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 올바른 값이 아니면 예외가 발생한다.")
    @ValueSource(strings = {"U ", " D", "Dx", "u", "d", "", "F"})
    @ParameterizedTest
    void testMoving(String input) {
        assertThatThrownBy(() -> ValidateInput.bridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 올바른 값이 아니면 예외가 발생한다.")
    @ValueSource(strings = {"R ", " Q", "Qx", "q", "r", "", "F"})
    @ParameterizedTest
    void testGameCommand(String input) {
        assertThatThrownBy(() -> ValidateInput.bridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
