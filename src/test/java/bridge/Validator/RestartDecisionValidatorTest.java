package bridge.Validator;

import bridge.Enum.ErrorMessage;
import bridge.Validator.Integarated.PlayerMoveValidator;
import bridge.Validator.Integarated.RestartDecisionValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RestartDecisionValidatorTest {
    private final RestartDecisionValidator restartDecisionValidator = new RestartDecisionValidator();

    @Test
    void isCorrectMoveFailure() {
        String wrongInput = "U";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> restartDecisionValidator.validate(wrongInput)
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo(ErrorMessage.RESTART_INPUT_ERROR.getMessage());
    }
}
