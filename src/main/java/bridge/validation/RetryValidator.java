package bridge.validation;

import bridge.resource.ErrorMessage;
import bridge.view.InputView;
import java.util.List;

public class RetryValidator {
    private static final List<String> tryPossibilityValue = List.of("Q", "R");
    private static final InputView INPUT_VIEW = new InputView();

    public String retryValidator() {
        try {
            String input = INPUT_VIEW.readGameCommand();
            retryValidator(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryValidator();
        }
    }

    private void retryValidator(String data) {
        if (checkTryInputData(data)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_RETRY_ERROR);
    }

    public boolean checkTryInputData(String data) {
        return tryPossibilityValue.contains(data);
    }
}
