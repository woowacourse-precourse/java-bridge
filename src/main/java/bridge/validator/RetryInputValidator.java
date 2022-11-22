package bridge.validator;

import bridge.constants.ValidatorMessage;

public class RetryInputValidator {

    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static void validateRetryInput(String nextSpace) {
        if (!nextSpace.equals(RETRY) && !nextSpace.equals(QUIT)) {
            throw new IllegalArgumentException(ValidatorMessage.RETRY_INPUT_IS_R_OR_Q.toString());
        }
    }
}
