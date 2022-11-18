package bridge.view;

import bridge.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("다리의 길이로 3이상 20이하의 숫자외의 입력시 예외가 발생한다")
    @Test
    void inputBridgeSizeInvalid() {
        assertThatThrownBy(() -> inputView.readBridgeSize(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readBridgeSize("76"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readBridgeSize("이십"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이로 3이상 20이하의 숫자 입력시 해당 수를 반환한다")
    @Test
    void inputBridgeSizeValid() {
        assertThat(inputView.readBridgeSize("20")).isEqualTo(20);
    }
}
