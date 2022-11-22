package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    public void bridgeSizeValidator() {
        //given
        String bridgeSize1 = "3abc";
        String bridgeSize2 = "-2";

        //then
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSize1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3 이상 20 이하인 숫자로 입력 가능합니다.");

        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSize2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3 이상 20 이하인 숫자로 입력 가능합니다.");

    }

    @Test
    public void userMovingValidator() {
        //given
        String moving1 = "UU";
        String moving2 = "1a2b3";

        //then
        assertThatThrownBy(() -> Validator.validateMoving(moving1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> Validator.validateMoving(moving2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    public void userRestartValidator() {
        //given
        String restart1 = "RR";
        String restart2 = "R1123";

        //then
        assertThatThrownBy(() -> Validator.validateRestartChoice(restart1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> Validator.validateRestartChoice(restart2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}