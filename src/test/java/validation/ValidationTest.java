package validation;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @Test
    void validateBridgeSizeTest() {
        String stringValue = "three";
        String negativeValue = "-1";
        String zeroValue = "0";
        String doubleValue = "1.1";

        InputValidation validator = new InputValidation();

        assertThatThrownBy(() -> validator.validateBridgeSize(stringValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateBridgeSize(negativeValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateBridgeSize(zeroValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateBridgeSize(doubleValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
