package View;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputViewTest {

    @DisplayName("다리 길이의 범위 초과")
    @Test
    void 다리길이_범위초과() {
        assertThatThrownBy(() -> new InputView().validateBridgeSize("1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력이 숫자가 아닌 경우")
    @Test
    void 다리길이_숫자가아닌경우(){
        assertThatThrownBy(() -> new InputView().validateBridgeSize("100j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동칸이 U,D가 아닌 경우")
    @Test
    void 이동칸_U_D가아닌경우() {
        assertThatThrownBy(() -> new InputView().validateMovingBlockInput("E"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 다시 시작 명령이 지정된 명령어가 아닌 경우")
    @Test
    void 게임다시시작_R_Q가아닌경우() {
        assertThatThrownBy(() -> new InputView().validateGameCommand("U"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}