package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validIsNum() {
        //given
        Validator validator = new Validator();
        String userInput = "a";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validIsNum(userInput);
        });

        //then
        Assertions.assertThat(exception.getMessage()).isEqualTo(ErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @Test
    void validRange() {
        //given
        Validator validator = new Validator();
        String userInput1 = "2";
        String userInput2 = "21";

        //when
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            validator.validRange(userInput1);
        });

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            validator.validRange(userInput2);
        });

        //then
        Assertions.assertThat(exception1.getMessage()).isEqualTo(ErrorMessage.IS_NOT_IN_RANGE.getMessage());
        Assertions.assertThat(exception2.getMessage()).isEqualTo(ErrorMessage.IS_NOT_IN_RANGE.getMessage());
    }

    @Test
    void validMovingInput() {
        //given
        Validator validator = new Validator();
        String userInput1 = "A";
        String userInput2 = "1";

        //when
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            validator.validMovingInput(userInput1);
        });

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            validator.validMovingInput(userInput2);
        });

        //then
        Assertions.assertThat(exception1.getMessage()).isEqualTo(ErrorMessage.IS_NOT_PERMIT_MOVING_INPUT.getMessage());
        Assertions.assertThat(exception2.getMessage()).isEqualTo(ErrorMessage.IS_NOT_PERMIT_MOVING_INPUT.getMessage());
    }

    @Test
    void validGameCommandInput() {
        //given
        Validator validator = new Validator();
        String userInput1 = "A";
        String userInput2 = "1";

        //when
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            validator.validGameCommandInput(userInput1);
        });

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            validator.validGameCommandInput(userInput2);
        });

        //then
        Assertions.assertThat(exception1.getMessage()).isEqualTo(ErrorMessage.IS_NOT_PERMIT_GAME_COMMAND.getMessage());
        Assertions.assertThat(exception2.getMessage()).isEqualTo(ErrorMessage.IS_NOT_PERMIT_GAME_COMMAND.getMessage());
    }
}