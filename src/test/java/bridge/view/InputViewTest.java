package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("다리 길이가 3 이상 20 이하가 아니면 예외가 발생한다.")
    @Test
    void bridgeSizeByRange() {
        InputView inputView = new InputView();
        int size = 33;
        assertThatThrownBy(() -> inputView.validateSizeNumber(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}