package bridge.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Retry {
    AGAIN(true, "R"),
    END(false,"Q");

    private final String retryInput;
    private final boolean retryIntention;

    Retry(boolean retryIntention, String retryInput) {
        this.retryIntention = retryIntention;
        this.retryInput = retryInput;
    }

    public static boolean getRetryIntention(Retry retryEnum) { // 이럼 안될라나?
        return retryEnum.retryIntention;
    }

    public static Retry getProperRetryEnum(String givenInput) {
        if ((givenInput.toLowerCase()).equals("R".toLowerCase())) {
            return AGAIN;
        }

        return END;
    }
}
