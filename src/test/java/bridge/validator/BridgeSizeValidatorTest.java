package bridge.validator;

import bridge.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeSizeValidatorTest {

    @Test
    void 다리길이_입력이_3이상_20이하가_아니라면_예외가_발생한다() {
        String minusInput = "-1";
        String underInput = "2";
        String overInput = "21";

        Assertions.assertThatThrownBy(() -> BridgeSizeValidator.validateBridgeSize(minusInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_BRIDGE_SIZE);
        Assertions.assertThatThrownBy(() -> BridgeSizeValidator.validateBridgeSize(underInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_BRIDGE_SIZE);
        Assertions.assertThatThrownBy(() -> BridgeSizeValidator.validateBridgeSize(overInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_BRIDGE_SIZE);
    }

    @Test
    void 다리길이_입력이_숫자가_아니라면_예외를_발생한다() {
        String input = "a10";
        Assertions.assertThatThrownBy(() -> BridgeSizeValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_BRIDGE_SIZE_TYPE);
    }

}