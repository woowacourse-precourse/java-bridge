package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @Test
    void 올바른_입력() {
        InputView inputView = new InputView();
        Assertions.assertThat(inputView.readBridgeSize("10"))
                .isEqualTo(10);
    }

    @Test
    void 숫자가_아닌_입력() {
        InputView inputView = new InputView();
        Assertions.assertThatThrownBy(()->inputView.readBridgeSize("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자의_범위에_맞지_않는_입력() {
        InputView inputView = new InputView();
        Assertions.assertThatThrownBy(()->inputView.readBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}