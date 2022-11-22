package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("숫자가 아닌 값을 입력하면 IllegalArgumentException 이 발생한다.")
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

    @DisplayName("3~20 이외의 숫자 값을 입력하면 IllegalArgumentException 이 발생한다.")
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

    @DisplayName("MovingInput 값에 U 또는 D 외의 값을 입력하면 IllegalArgumentException 이 발생한다.")
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

    @DisplayName("R 또는 Q 이외의 값을 입력하면 IllegalArgumentException 이 발생한다.")
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