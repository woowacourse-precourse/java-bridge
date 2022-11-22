package bridge.validator;

import bridge.util.validator.InputValidator;
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

    @Test
    void validateMoving_anotherString_throwException() {
        String input = "F";
        assertThatThrownBy(() -> InputValidator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateMoving_anotherString_zeroSize() {
        String input = "";
        assertThatThrownBy(() -> InputValidator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateMoving_anotherString_overSize() {
        String input = "UU";
        assertThatThrownBy(() -> InputValidator.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}