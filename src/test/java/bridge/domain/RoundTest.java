package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {
    private void getUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("이동할 칸 입력이 U 또는 D가 아니면 예외가 발생한다.")
    @Test
    void inputMovingByInvalidValue() {
        getUserInput("a");
        assertThatThrownBy(InputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이동할 칸 입력은 U 또는 D여야 합니다.");
    }

    @DisplayName("이동할 칸 입력이 U면 예외가 발생하지 않는다.")
    @Test
    void inputMovingByU() {
        getUserInput("U");
        assertThat(InputView.readMoving()).isEqualTo("U");
    }

    @DisplayName("이동할 칸 입력이 D면 예외가 발생하지 않는다.")
    @Test
    void inputMovingByD() {
        getUserInput("D");
        assertThat(InputView.readMoving()).isEqualTo("D");
    }
}
