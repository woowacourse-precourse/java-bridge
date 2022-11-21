package bridge.view;

import bridge.config.BridgeAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView inputView;
    @BeforeEach
    public void beforeEach(){
        inputView = BridgeAppConfig.inputView();
    }
    @Test
    public void bridgeInputRangeTest() throws Exception{
        Assertions.assertThatThrownBy(()->inputView.bridgeSizeValidate("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void bridgeInputDigitTest() throws Exception{
        Assertions.assertThatThrownBy(()->inputView.bridgeSizeValidate("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void movingInputTest() throws Exception{
        Assertions.assertThatThrownBy(()-> inputView.movingValidate("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void gameCommandTest() throws Exception{
        Assertions.assertThatThrownBy(()->inputView.gameCommandValidate("S"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}