import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    @DisplayName("다리 길이 입력 시 아무 것도 입력하지 않으면 예외가 발생한다.")
    @Test
    void noInputException() {
        assertThatThrownBy(() -> InputValidator.bridgeSize(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 없습니다.");
    }

    @DisplayName("다리 길이 입력 시 숫자 형태가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"one", "둘", "8teen", "7곱"})
    void nonDigitInputException(String input) {
        assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력값은 숫자 형태만 받을 수 있습니다.");
    }

    @DisplayName("다리 길이 입력 시 3 ~ 20 사이의 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "21", "2"})
    void nonDigitInput(String input) {
        assertThatThrownBy(() -> InputValidator.bridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(
                        "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                        MINIMUM_BRIDGE_SIZE,
                        MAXIMUM_BRIDGE_SIZE
                ));
    }
}
