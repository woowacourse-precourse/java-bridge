package bridge.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeValidationTest {
    private BridgeSizeValidation bridgeSizeValidation;

    @BeforeEach
    void setUp() {
        bridgeSizeValidation = new BridgeSizeValidation();
    }

    @DisplayName("숫자가 아닌 문자가 들어오면 예외처리")
    @Test
    void validateWhenInputNotNumber() {
        assertThatThrownBy(() -> bridgeSizeValidation.validate("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3~20 범위 이외의 숫자가 들어오면 예외처리")
    @Test
    void validateOutOfRange() {
        assertThatThrownBy(() -> bridgeSizeValidation.validate("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> bridgeSizeValidation.validate("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}