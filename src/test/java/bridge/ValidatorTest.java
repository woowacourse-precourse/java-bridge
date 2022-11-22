package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {
    @Test
    public void isNumber() {
        assertThatThrownBy(() -> Validator.isNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.isNumber(" 1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.isNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);

        Validator.isNumber("1");
    }

    @Test
    public void isLargerOrEqual() {
        assertThatThrownBy(() -> Validator.isLargerOrEqual(10, 9))
                .isInstanceOf(IllegalArgumentException.class);

        Validator.isLargerOrEqual(10, 10);
    }

    @Test
    public void isSmallerOrEqual() {
        assertThatThrownBy(() -> Validator.isSmallerOrEqual(10, 11))
                .isInstanceOf(IllegalArgumentException.class);

        Validator.isSmallerOrEqual(10, 10);
    }

    @ParameterizedTest
    @CsvSource({"1", "23", "10a"})
    public void validatedBridgeSize(String input) {
        assertThatThrownBy(() -> Validator.validatedBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateMoving() {
        assertThatThrownBy(() -> Validator.validateMoving("Q"))
                .isInstanceOf(IllegalArgumentException.class);

        Validator.validateMoving("u");
        Validator.validateMoving("D");
    }

    @Test
    public void validateGameCommand() {
        assertThatThrownBy(() -> Validator.validateGameCommand("D"))
                .isInstanceOf(IllegalArgumentException.class);

        Validator.validateGameCommand("q");
        Validator.validateGameCommand("R");
    }
}