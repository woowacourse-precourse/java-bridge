package bridge.validator;

import bridge.constant.ValidatorMessage;

public class RetryInputValidator {

    public static void validateRetryInput(String nextSpace) {
        if (!nextSpace.equals("R") && !nextSpace.equals("Q")) {
            throw new IllegalArgumentException(ValidatorMessage.RETRY_INPUT_IS_R_OR_Q.toString());
        }
    }
}
