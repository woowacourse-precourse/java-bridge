package bridge.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewValidationTest {

    @Test
    void validateIsInteger() {
        assertThatThrownBy(() -> InputViewValidation.validateIsInteger("123가"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateIsInRangeBySmallNumber() {
        assertThatThrownBy(() -> InputViewValidation.validateIsInRange("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateIsInRangeByBigNumber() {
        assertThatThrownBy(() -> InputViewValidation.validateIsInRange("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateIsUorDByA(){
        assertThatThrownBy(() -> InputViewValidation.validateIsUorD("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateIsRorQByA(){
        assertThatThrownBy(() -> InputViewValidation.validateIsRorQ("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}