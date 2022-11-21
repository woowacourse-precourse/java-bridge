package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewReadBridgeSizeTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 다리 길이가 숫자가 아닌 경우 에러 발생")
    @Test
    void readBridgeSizeValidErrorTest() {
        String input = "abc";

        assertThatThrownBy(() -> inputView.sizeValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다");
    }

    @DisplayName("입력 받은 다리 길이가 숫자가 3보다 작은 경우")
    @Test
    void readBridgeSizeValidErrorTest2() {
        String input = "-2";

        assertThatThrownBy(() -> inputView.sizeValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다");
    }

    @DisplayName("입력 받은 다리 길이가 숫자가 20보다 큰 경우")
    @Test
    void readBridgeSizeValidErrorTest3() {
        String input = "20.5";

        assertThatThrownBy(() -> inputView.sizeValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다");
    }

    @DisplayName("입력 받은 다리 길이가 5인 경우")
    @Test
    void movingValidErrorTestU() {
        String input = "5";

        inputView.sizeValidation(input);

        assertThatNoException();
    }
}