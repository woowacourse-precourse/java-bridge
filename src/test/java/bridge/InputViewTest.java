package bridge;
import bridge.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {
    InputView inputView = new InputView();

    //@DisplayName("입력값이 3 이상 20 이하 입력 시 예외가 발생한다.")
    @Test
    void 다리길이_예외() {
        String Input = "30";
        assertThatThrownBy(() -> inputView.checkLengthValidate(Input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @Test
    void 이동관련_입력_예외() {
        String input = "A";
        assertThatThrownBy(() -> inputView.checkMoveValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동 관련 입력은 U와 D만 사용 가능합니다.");
    }

    @Test
    void 게임_재시작관련_입력_예외() {
        String input = "C";
        assertThatThrownBy(() -> inputView.checkRetryValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 종료 및 재시작 관련 입력은 R와 Q만 사용 가능합니다.");
    }
}