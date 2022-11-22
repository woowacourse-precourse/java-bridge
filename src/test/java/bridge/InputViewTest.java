package bridge;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    @Test
    void 다리길이_예외() {
        String Input = "30";
        assertThatThrownBy(() -> InputView.checkLengthValidate(Input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.Length_Restrict());
    }

    @Test
    void 이동관련_입력_예외() {
        String input = "A";
        assertThatThrownBy(() -> InputView.checkMoveValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.Move_Restrict());
    }

    @Test
    void 게임_재시작관련_입력_예외() {
        String input = "C";
        assertThatThrownBy(() -> InputView.checkRetryValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.Replay_Restrict());
    }
}
