package bridge.Validator;

import bridge.Enum.ErrorMessage;
import bridge.Validator.Integarated.PlayerMoveValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerMoveValidatorTest {
    private final PlayerMoveValidator playerMoveValidator = new PlayerMoveValidator();

    @Test
    void isCorrectMoveFailure() {
        String wrongMove = "S";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> playerMoveValidator.validate(wrongMove)
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo(ErrorMessage.UPDWON_INPUT_ERROR.getMessage());
    }
}
