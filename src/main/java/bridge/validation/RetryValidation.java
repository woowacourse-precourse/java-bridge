package bridge.validation;

import bridge.message.ErrorMessage;
import java.util.List;

public class RetryValidation {
    private static final List<String> tryPossibilityValue = List.of("Q", "R");


    public void retryValidation(String data) {
        if (checkTryInputData(data)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_RETRY_ERROR);
    }

    public boolean checkTryInputData(String data) {
        return tryPossibilityValue.contains(data);
    }
}
