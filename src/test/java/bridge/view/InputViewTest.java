package bridge.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("입력된 값의 길이 자체가 유효하지 않은 경우에 대한 예외처리")
    @ValueSource(strings = {"123", ""})
    @ParameterizedTest
    void bridge_invalid_value_length_test(String userInput) {
        assertThatThrownBy(() -> InputView.getInstance().validateBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이로 숫자가 입력되지 않은 경우에 대한 예외처리")
    @ValueSource(strings = {"2a", "-2", "5E", "6#", "**"})
    @ParameterizedTest
    void bridge_length_not_digit_test(String userInput) {
        assertThatThrownBy(() -> InputView.getInstance().validateBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3 ~ 20 사이의 범위가 아닌 경우에 대한 예외처리")
    @ValueSource(strings = {"2", "21", "123", "0"})
    @ParameterizedTest
    void bridge_length_range_test(String userInput) {
        assertThatThrownBy(() -> InputView.getInstance().validateBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
