package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewReadMovingTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 이동 칸이 U 또는 D가 아닌 경우")
    @Test
    void movingValidErrorTest() {
        String input = "abc";

        assertThatThrownBy(() -> inputView.movingValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] U(위 칸) 또는 D(아래 칸) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 U인 경우")
    @Test
    void movingValidErrorTestU() {
        String input = "U";

        inputView.movingValidation(input);

        assertThatNoException();
    }

    @DisplayName("입력 받은 이동 칸이 D인 경우")
    @Test
    void movingValidErrorTestD() {
        String input = "D";

        inputView.movingValidation(input);

        assertThatNoException();
    }
}