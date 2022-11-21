package validation;


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

    @Test
    void validateMovingTest() {
        String lowercaseInput = "u";
        String wrongAlphabetInput = "C";
        String numberInput = "1";

        InputValidation validator = new InputValidation();

        assertThatThrownBy(() -> validator.validateMoving(lowercaseInput))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateMoving(wrongAlphabetInput))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateMoving(numberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateGameCommandTest() {
        String validInput = "Q";
        String lowercaseInput = "r";
        String wrongAlphabetInput = "S";
        String numberInput = "1";

        InputValidation validator = new InputValidation();

        assertThatThrownBy(() -> validator.validateGameCommand(lowercaseInput))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateGameCommand(wrongAlphabetInput))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateGameCommand(numberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
