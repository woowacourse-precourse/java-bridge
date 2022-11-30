package bridge.enums;

import bridge.Constants;

public enum Retry {
    AGAIN(true, Constants.UserChoices.AGAIN_UPPER),
    END(false,Constants.UserChoices.QUIT_UPPER);

    private final String retryInput;
    private final boolean retryIntention;

    Retry(boolean retryIntention, String retryInput) {
        this.retryIntention = retryIntention;
        this.retryInput = retryInput;
    }

    public static boolean getRetryIntention(Retry retryEnum) {
        return retryEnum.retryIntention;
    }

    public static Retry getProperRetryEnum(String givenInput) {
        if ((givenInput).equalsIgnoreCase(Constants.UserChoices.AGAIN_UPPER)) {
            return AGAIN;
        }

        return END;
    }
}
