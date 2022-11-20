package bridge.validator;

import bridge.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MovingValidatorTest {
    @Test
    void 다리_건너기_입력이_U_또는_D가_아니라면_예외를_발생한다(){
        String lowerInput = "u";
        String wrongInput = "I";

        Assertions.assertThatThrownBy(() -> MovingValidator.validateMoving(lowerInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_MOVING_VALUE);
        Assertions.assertThatThrownBy(() -> MovingValidator.validateMoving(wrongInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_MOVING_VALUE);
    }
}