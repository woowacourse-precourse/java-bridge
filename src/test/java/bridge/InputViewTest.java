package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    static InputView inputView;

    @BeforeAll
    static void setup() {
        inputView = new InputView();
    }

    @DisplayName("InputView 통해 BridgeSize 입력 시 Integer 가 아니라 String 입력 시 예외가 발생한다.")
    @Test
    void validIntegerTest() {
        assertThatThrownBy(() -> inputView.validInteger("hello"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
