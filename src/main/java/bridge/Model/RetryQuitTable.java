package bridge.Model;

public enum RetryQuitTable {
    RETRY("R", true),
    QUIT("Q", false);
    private String RetryOrQuit;
    private boolean isRetry;

    RetryQuitTable(String RetryOrQuit, boolean isRetry) {
        this.RetryOrQuit = RetryOrQuit;
        this.isRetry = isRetry;
    }

    private String getRetryOrQuit() {
        return this.RetryOrQuit;
    }

    private boolean getIsRetry() {
        return this.isRetry;
    }

    public static boolean get(String RetryOrQuit) {
        if (RETRY.getRetryOrQuit().equals(RetryOrQuit)) {
            return RETRY.isRetry;
        }
        return QUIT.isRetry;
    }
}
