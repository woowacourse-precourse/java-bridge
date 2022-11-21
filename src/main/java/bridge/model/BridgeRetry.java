package bridge.model;

public class BridgeRetry {

    private final String retry;

    public BridgeRetry(String retry) {
        validateRetry(retry);
        this.retry = retry;
    }
    public boolean isRetry(){
        return retry.equals(Retry.RETRY.getDescription());
    }

    public void validateRetry(String retry) {
        if (isRetryFormatCorrect(retry)) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.RETRY_NON_FORMAT_ERROR_MESSAGE.getMessage());
    }

    private static boolean isRetryFormatCorrect(String retry) {
        return retry.equals("R") || retry.equals("Q");
    }
}
