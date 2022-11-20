package model.enums;

import static model.BridgeGameExceptions.NOT_A_RETRY_INTENTION;

import java.util.Arrays;

public enum RetryIntention {
    RETRY("R", true), QUIT("Q", false);

    public final String intention;
    public final boolean wantRetry;

    RetryIntention(String intention, boolean wantRetry) {
        this.intention = intention;
        this.wantRetry = wantRetry;
    }

    public static boolean wantRetry(String userIntention) {

        RetryIntention retryIntention = Arrays.stream(RetryIntention.values())
                .filter((intention) -> intention.intention.equals(userIntention)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_A_RETRY_INTENTION));
        return retryIntention.wantRetry;
    }
}
