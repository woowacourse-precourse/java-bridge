package bridge.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    void setInputView() {
        inputView = new InputView();
    }

    @Test
    void 다리_길이_숫자_확인_테스트() {
        String input = "abc";

        assertThatThrownBy(() -> inputView.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_범위_테스트() {
        String input = "22";

        assertThatThrownBy(() -> inputView.checkScope(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_커멘드_테스트() {
        String input = "I";

        assertThatThrownBy(() -> inputView.isMovingCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_종료_커멘드_테스트() {
        String input = "I";

        assertThatThrownBy(() -> inputView.isGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}