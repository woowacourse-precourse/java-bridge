package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @Test
    public void bridgeInputRangeTest() throws Exception{
        InputView inputView = new InputView();
        Assertions.assertThatThrownBy(()->inputView.bridgeSizeValidate("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void bridgeInputDigitTest() throws Exception{
        InputView inputView = new InputView();
        Assertions.assertThatThrownBy(()->inputView.bridgeSizeValidate("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}