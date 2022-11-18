package bridge.validator;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void validateBridgeSize_string_throwException() {
        String input = "fdsf";
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBridgeSize_overRange_throwException() {
        String input = "0";
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBridgeSize_float_throwException() {
        String input = "3.5";
        assertThatThrownBy(() -> InputValidator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}