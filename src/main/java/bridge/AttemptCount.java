package bridge;

public class AttemptCount {
    public static final int INIT_GAME_ATTEMPT = 1;
    public static final int GAME_RESTART_COUNT = 1;
    private int attemptCount;

    public AttemptCount() {
        this.attemptCount = INIT_GAME_ATTEMPT;
    }

    public AttemptCount plus() {
        attemptCount = attemptCount + GAME_RESTART_COUNT;
        return this;
    }

    public int getAttemptCount(){
        return attemptCount;
    }
}
