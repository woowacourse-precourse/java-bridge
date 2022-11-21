package bridge.ModelTest;

import bridge.Model.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest extends InputView {

    @DisplayName("입력값이 3 이상 20 이하 입력 시 예외가 발생한다.")
    @Test
    void 다리길이_범위_예외() {
        String input = "21";
        assertThatThrownBy(() -> checkRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 다리길이_입력값_숫자_예외() {
        String input = "aa";
        assertThatThrownBy(() -> checkNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 숫자여야 합니다.");
    }

    @DisplayName("이동 입력값이 U/D 가 아니면 예외가 발생한다.")
    @Test
    void 이동_입력_예외() {
        String input = "A";
        assertThatThrownBy(() -> checkDirection(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동 방향 여부는 'U(위)'/'D(아래)' 만 가능합니다.");
    }

    @DisplayName("게임 재시작/종료 입력 값이 R, Q 가 아니면 예외가 발생한다.")
    @Test
    void 게임_진행_입력값_예외() {
        String input = "C";
        assertThatThrownBy(() -> checkProgress(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 진행 여부는 'R(재시작)'/'Q(종료)' 만 가능합니다.");
    }

}
