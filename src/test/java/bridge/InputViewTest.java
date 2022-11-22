package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static bridge.InputView.*;

public class InputViewTest {

    static InputView inputView = new InputView();
    static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리길이_오류입력1() {
        String input = "30";
        assertThatThrownBy(() -> inputView.checkBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 다리길이_오류입력2() {
        String input = "3s";
        assertThatThrownBy(() -> inputView.checkBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 이동방향_오류입력() {
        String input = "P";
        assertThatThrownBy(() -> inputView.checkMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 이동방향_소문자_오류입력() {
        String input = "p";
        assertThatThrownBy(() -> inputView.checkMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 이동방향_소문자입력() {
        Assertions.assertThat(inputView.checkMoving("u")).isEqualTo("U");
    }

    @Test
    void 재시작여부_오류입력() {
        String input = "P";
        assertThatThrownBy(() -> inputView.checkGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 재시작여부_소문자_오류입력() {
        String input = "p";
        assertThatThrownBy(() -> inputView.checkGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 재시작여부_소문자입력() {
        Assertions.assertThat(inputView.checkGameCommand("r")).isEqualTo("R");
    }
}
