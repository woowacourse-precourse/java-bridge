package bridge.domain;

public class Attempt {
    private int attempt;

    public Attempt() {
        this.attempt = 0;
    }

    public void increase() {
        this.attempt++;
    }

    public int getAttempt() {
        return attempt;
    }
}
