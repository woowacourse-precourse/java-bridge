package bridge.Validator;

import bridge.Validator.Integarated.BridgeSizeValidator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static bridge.Enum.ErrorMessage.NUMERIC_ERROR;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BridgeSizeValidatorTest {

    private final BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();

    @Test
    public void isNumericFailure() {
        String wrongNumberTarget = "1j";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> bridgeSizeValidator.validate(wrongNumberTarget)
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo(NUMERIC_ERROR.getMessage());
    }

}
