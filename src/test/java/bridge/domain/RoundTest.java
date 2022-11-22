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

    @DisplayName("재시도 여부 입력이 R 또는 Q가 아니면 예외가 발생한다.")
    @Test
    void inputCommandByInvalidValue() {
        getUserInput("a");
        assertThatThrownBy(InputView::readGameCommand)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 재시도 여부 입력은 R 또는 Q여야 합니다.");
    }

    @DisplayName("재시도 여부 입력이 R이면 예외가 발생하지 않는다.")
    @Test
    void inputCommandByR() {
        getUserInput("R");
        assertThat(InputView.readGameCommand()).isEqualTo("R");
    }

    @DisplayName("재시도 여부 입력이 Q면 예외가 발생하지 않는다.")
    @Test
    void inputCommandByQ() {
        getUserInput("Q");
        assertThat(InputView.readGameCommand()).isEqualTo("Q");
    }
}
