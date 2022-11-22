package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewReadGameCommandTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 값이 R 또는 Q가 아닌 경우")
    @ValueSource(strings = {"abc", "test", "한글"})
    @ParameterizedTest
    void movingValidErrorTest(String input) {
        assertThatThrownBy(() -> inputView.gameCommandValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] R(재시도) 또는 Q(종료) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 소문자인 경우")
    @ValueSource(strings = {"r", "q"})
    @ParameterizedTest
    void movingValidErrorTestLower(String input) {
        assertThatThrownBy(() -> inputView.gameCommandValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] R(재시도) 또는 Q(종료) 중 하나의 문자여야 합니다");
    }

    @DisplayName("입력 받은 이동 칸이 R 또는 Q인 경우")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void movingValidErrorCorrectTest(String input) {
        inputView.gameCommandValidation(input);

        assertThatNoException();
    }
}