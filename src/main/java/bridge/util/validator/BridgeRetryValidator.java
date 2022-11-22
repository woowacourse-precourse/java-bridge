package bridge.util.validator;

import bridge.util.Constants;

public class BridgeRetryValidator {

    private String retryMessage;

    public BridgeRetryValidator(String retryMessage) {
        this.retryMessage = retryMessage;
        isEmpty();
        isRightLength();
        isRightForm();
    }

    public void isEmpty() {
        if (retryMessage.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_RETRY_EMPTY);
        }
    }

    public void isRightLength() {
        if (retryMessage.length() != 1) {
            throw new IllegalArgumentException(Constants.ERROR_RETRY_RIGHT_LENGTH);
        }
    }

    public void isRightForm() {
        if (!((retryMessage.equals("R")) || (retryMessage.equals("Q")))) {
            throw new IllegalArgumentException(Constants.ERROR_RETRY_RIGHT_FORM);
        }
    }
}
