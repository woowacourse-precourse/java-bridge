package bridge.Validator.Integarated;

import bridge.Enum.ErrorMessage;
import bridge.Validator.RestartValidator;

public class RestartDecisionValidator implements RestartValidator {
    public void validate(String input) {
        if (!isCorrectDecision(input)) {
            throw new IllegalArgumentException(ErrorMessage.RESTART_INPUT_ERROR.getMessage());
        }
    }
}
