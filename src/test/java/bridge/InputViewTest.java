package bridge;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {
    InputView inputView = new InputView();
    private static Constant constant = new Constant();

    @Test
    void 다리길이_예외() {
        String Input = "30";
        assertThatThrownBy(() -> inputView.checkLengthValidate(Input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(constant.Length_Restrict());
    }

    @Test
    void 이동관련_입력_예외() {
        String input = "A";
        assertThatThrownBy(() -> inputView.checkMoveValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(constant.Move_Restrict());
    }

    @Test
    void 게임_재시작관련_입력_예외() {
        String input = "C";
        assertThatThrownBy(() -> inputView.checkRetryValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(constant.Replay_Restrict());
    }
}