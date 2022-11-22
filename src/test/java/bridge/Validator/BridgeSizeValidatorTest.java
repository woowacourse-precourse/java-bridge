package bridge.Validator;

import bridge.Enum.BridgeInfo;
import bridge.Enum.ErrorMessage;
import bridge.Validator.Integarated.BridgeSizeValidator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static bridge.Enum.ErrorMessage.NUMERIC_ERROR;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static bridge.Enum.ErrorMessage.BRIDGE_SIZE_ERROR;

class BridgeSizeValidatorTest {

    private final BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();

    @Test
    void isNumericFailure() {
        String wrongNumberTarget = "1j";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> bridgeSizeValidator.validate(wrongNumberTarget)
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo(NUMERIC_ERROR.getMessage());
    }

    @Test
    void isValidRangeFailure() {
        int input = BridgeInfo.MAX_SIZE.getInfo() + 1;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> bridgeSizeValidator.validate(String.valueOf(input))
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo(BRIDGE_SIZE_ERROR.getMessage());
    }

}
