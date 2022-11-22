package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewReadMovingTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 이동 칸이 U 또는 D가 아닌 경우")
    @ValueSource(strings = {"abc", "test", "한글"})
    @ParameterizedTest
    void movingValidErrorTest(String input) {
        assertThatThrownBy(() -> inputView.movingValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] U(위 칸) 또는 D(아래 칸) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 소문자인 경우")
    @ValueSource(strings = {"u", "d"})
    @ParameterizedTest
    void movingValidErrorTestLower(String input) {
        assertThatThrownBy(() -> inputView.movingValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] U(위 칸) 또는 D(아래 칸) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 U인 경우")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void movingValidTest(String input) {
        inputView.movingValidation(input);

        assertThatNoException();
    }
}