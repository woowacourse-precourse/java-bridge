package bridge.model;

public class Player {

    private int attempt = 1;

    public void attempt() {
        attempt += 1;
    }

    public int getAttempt() {
        return attempt;
    }

}
