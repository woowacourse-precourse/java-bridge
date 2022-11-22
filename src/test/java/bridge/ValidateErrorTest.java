package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidateErrorTest {
    ValidateError validateError = new ValidateError();
    @Test
    void validIsNumber() {
        /*given*/
        String userInput = "a";
        NumberFormatException exceptionTest = assertThrows(NumberFormatException.class, () -> {
            validateError.validIsNumber(userInput);
        });
        /*when*/
        /*then*/
        assertThat(ErrorMessage.NOT_NUMBER.getMessage()).isEqualTo(exceptionTest.getMessage());
    }

    @Test
    void validIsInRange() {
        /*given*/
        String userInput = "21";
        IllegalArgumentException exceptionTest = assertThrows(IllegalArgumentException.class, () -> {
            validateError.validIsInRange(userInput);
        });
        /*when*/
        /*then*/
        assertThat(ErrorMessage.NOT_IN_RANGE.getMessage()).isEqualTo(exceptionTest.getMessage());
    }

    @Test
    void validIsNotSuitableMovingCommand() {
        /*given*/
        String userInput = "T";
        IllegalArgumentException exceptionTest = assertThrows(IllegalArgumentException.class, () -> {
            validateError.validIsNotSuitableMovingCommand(userInput);
        });
        /*when*/
        /*then*/
        assertThat(ErrorMessage.NOT_SUITABLE_MOVING_COMMAND.getMessage()).isEqualTo(exceptionTest.getMessage());
    }

    @Test
    void validIsNotSuitableEndCommand() {
        /*given*/
        String userInput = "T";
        IllegalArgumentException exceptionTest = assertThrows(IllegalArgumentException.class, () -> {
            validateError.validIsNotSuitableEndCommand(userInput);
        });
        /*when*/
        /*then*/
        assertThat(ErrorMessage.NOT_SUITABLE_END_COMMAND.getMessage()).isEqualTo(exceptionTest.getMessage());
    }
}