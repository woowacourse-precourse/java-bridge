package bridge.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    Validator validator = new Validator();

    @Test
    public void validateBridgeSizeFormat_숫자_아닌_값_입력시에_예외() throws Exception {
        String bridgeSize = "10k";

        assertThatThrownBy(() -> validator.validateBridgeSizeFormat(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateBridgeSizeRange_3이상_20이하_아닌_값_입력시에_예외() throws Exception {
        String bridgeSize = "30";

        assertThatThrownBy(() -> validator.validateBridgeSizeRange(bridgeSize,3,20))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateStep_U_D_아닌_값_입력시에_예외() throws Exception {
        String step = "Z";

        assertThatThrownBy(() -> validator.validateStep(step))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateRetryCommand_R_Q_아닌_값_입력시에_예외() throws Exception {
        String command = "Z";

        assertThatThrownBy(() -> validator.validateRetryCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}