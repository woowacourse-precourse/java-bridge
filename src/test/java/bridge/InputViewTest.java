package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @DisplayName("다리 길이가 숫자가 아닐 때 예외 발생")
    @Test
    void bridgeSizeIsNotNumber() {
        InputView input = new InputView();
        assertThatThrownBy(() -> input.validateBridgeSize("l"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3 이상 20 이하가 아닐 때 예외 발생")
    @Test
    void bridgeSizeOutOfRange() {
        InputView input = new InputView();
        assertThatThrownBy(() -> input.validateBridgeSize("25"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 U나 D가 아닐 때 예외 발생")
    @Test
    void movingIsNotUpOrDown() {
        InputView input = new InputView();
        assertThatThrownBy(() -> input.validateUpOrDown("S"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 R이나 Q가 아닐 때 예외 발생")
    @Test
    void gameCommandIsNotRetryOrQuit() {
        InputView input = new InputView();
        assertThatThrownBy(() -> input.validateRetryOrQuit(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

