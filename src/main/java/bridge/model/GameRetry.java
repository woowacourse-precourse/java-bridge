package bridge.model;

import bridge.utils.InputValidator;

public class GameRetry {
    InputValidator inputValidator = new InputValidator();
    public void retryOrQuit(String retry) {
        inputValidator.isRetryValid(retry);
    }
}
