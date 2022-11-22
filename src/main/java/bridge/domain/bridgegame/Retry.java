package bridge.domain.bridgegame;

import java.util.Arrays;

public enum Retry {
    RESTART("R"),
    QUIT("Q");

    private final String retryValue;

    Retry(final String retryValue) {
        this.retryValue = retryValue;
    }

    public static Retry findRetry(String input) {
        return Arrays.stream(Retry.values())
                .filter(retry -> retry.isMatch(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] Retry enum 에 문제가 발생했습니다."));
    }

    private boolean isMatch(String input) {
        return this.retryValue.equals(input);
    }

    public String getRetryValue() {
        return retryValue;
    }
}
