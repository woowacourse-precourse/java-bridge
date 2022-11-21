package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewReadGameCommandTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 값이 R 또는 Q가 아닌 경우")
    @Test
    void movingValidErrorTest() {
        String input = "abc";

        assertThatThrownBy(() -> inputView.gameCommandValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] R(재시도) 또는 Q(종료) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 소문자 r인 경우")
    @Test
    void movingValidErrorTestLowerR() {
        String input = "r";

        assertThatThrownBy(() -> inputView.gameCommandValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] R(재시도) 또는 Q(종료) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 소문자 q인 경우")
    @Test
    void movingValidErrorTestLowerQ() {
        String input = "q";

        assertThatThrownBy(() -> inputView.gameCommandValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] R(재시도) 또는 Q(종료) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 R인 경우")
    @Test
    void movingValidErrorTestR() {
        String input = "R";

        inputView.gameCommandValidation(input);

        assertThatNoException();
    }

    @DisplayName("입력 받은 이동 칸이 Q인 경우")
    @Test
    void movingValidErrorTestQ() {
        String input = "Q";

        inputView.gameCommandValidation(input);

        assertThatNoException();
    }
}