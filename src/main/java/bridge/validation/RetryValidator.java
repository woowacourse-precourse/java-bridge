package bridge.validation;

import bridge.game.Player;
import bridge.resource.ErrorMessage;
import bridge.resource.GameConstant;
import bridge.view.OutputView;
import java.util.List;

public class RetryValidator {
    private static final List<String> tryPossibilityValue = List.of(GameConstant.EXIT, GameConstant.RE);

    public String retryValidator(String input) {
        try {
            retryValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return Player.requestInputRetryToValidation();
        }
    }

    private void retryValidation(String data) {
        if (checkTryInputData(data)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_RETRY_ERROR);
    }

    private boolean checkTryInputData(String data) {
        return tryPossibilityValue.contains(data);
    }
}
