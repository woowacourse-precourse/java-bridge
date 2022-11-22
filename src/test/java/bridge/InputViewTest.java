package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("숫자가 아닐때 예외처리")
    @Test
    void numberValidate() {
        String input = "sdf";
        assertThatThrownBy(() -> inputView.numberValidate(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("3과 20사이의 숫자가 아닐때 예외처리")
    @ValueSource(ints = {-3, 0, 21})
    @ParameterizedTest
    void rangeValidate(int size) {
        assertThatThrownBy(() -> inputView.rangeValidate(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" U 와 D 중 하나가 아닐때 예외처리")
    @ValueSource(strings = {"0", "-1", "u", "R"})
    @ParameterizedTest
    void movingValidate(String input) {
        assertThatThrownBy(() -> inputView.movingValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" R 와 Q 중 하나가 아닐때 예외처리")
    @ValueSource(strings = {"0", "-1", "D", "U"})
    @ParameterizedTest
    void GameCommandValidate(String input) {
        assertThatThrownBy(() -> inputView.GameCommandValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}