package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @DisplayName("다리 길이에 대한 입력은 숫자여야 하고, 3부터 20 사이의 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "12ab", "ab12", "ab", "-ab", "-1ab", "0", "-12", "25", "1"})
    void createBridgeLengthWrongInput(String input) {
        assertThatThrownBy(() -> InputView.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸에 대한 입력은 'U' 또는 'D'여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "UD", "12", "", "!"})
    void createMovingWrongInput(String input) {
        assertThatThrownBy(() -> InputView.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}