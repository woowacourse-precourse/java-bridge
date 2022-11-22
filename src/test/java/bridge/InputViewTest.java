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

    @DisplayName("InputView 통해 Move 입력 시 U 혹은 D 가 아닌 값을 입력 시 예외가 발생한다.")
    @Test
    void validMovingValueTest() {
        assertThatThrownBy(() -> inputView.validMoving("O"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("InputView 통해 retry 입력 시 R 혹은 Q 가 아닌 값을 입력 시 예외가 발생한다.")
    @Test
    void validRetryValueTest() {
        assertThatThrownBy(() -> inputView.validMoving("X"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
