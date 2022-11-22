package bridge.model;

public enum Command {
    R(true),
    Q(false);

    private final boolean retry;

    Command(boolean retry) {
        this.retry = retry;
    }

    public boolean getRetry() {
        return retry;
    }
}
