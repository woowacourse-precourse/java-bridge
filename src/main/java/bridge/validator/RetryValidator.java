package bridge.validator;

import static bridge.validator.ErrorMessage.*;

public class RetryValidator {
    public static final String runRetryValidator(String retryFlag) {
        if (isNotRorQ(retryFlag)) {
            throw new IllegalArgumentException(NOT_R_OR_Q.getErrorMessage());
        }
        return retryFlag;
    }

    private static boolean isNotRorQ(String retryFlag) {
        return !(retryFlag == "R" || retryFlag == "Q");
    }
}
