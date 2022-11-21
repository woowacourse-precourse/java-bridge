package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    public void bridgeSizeValidator() throws Exception{
        //given
        String bridgeSize1 = "3abc";
        String bridgeSize2 = "-2";

        //then
        assertThatThrownBy(()->validator.validateBridgeSize(bridgeSize1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3 이상 20 이하인 숫자로 입력 가능합니다.");

        assertThatThrownBy(()->validator.validateBridgeSize(bridgeSize2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3 이상 20 이하인 숫자로 입력 가능합니다.");

    }

    @Test
    public void userMovingValidator() throws Exception{
        //given
        String moving1 = "UU";
        String moving2 = "1a2b3";

        //then
        assertThatThrownBy(()-> validator.validateMoving(moving1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(()-> validator.validateMoving(moving2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    public void userRestartValidator() throws Exception{
        //given
        String restart1 = "RR";
        String restart2 = "R1123";

        //then
        assertThatThrownBy(()-> validator.validateRestartChoice(restart1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(()-> validator.validateRestartChoice(restart2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}