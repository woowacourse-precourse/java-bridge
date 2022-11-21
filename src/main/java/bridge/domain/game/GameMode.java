package bridge.domain.game;

public enum GameMode {
    RETRY("R", true),
    QUIT("Q", false);

    private String retryKey;
    private boolean retryOrNot;

    public String getKey() {
        return retryKey;
    }

    public boolean isRetryOrNot() {
        return retryOrNot;
    }

    GameMode(String retryKey, boolean retryOrNot) {
        this.retryKey = retryKey;
        this.retryOrNot = retryOrNot;
    }

    public boolean isRetry(String mode){
        return GameMode.valueOf(mode).retryOrNot;
    }

}
