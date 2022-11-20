package bridge.domain;

public class GameAttempt {

    private int attempt;

    public GameAttempt() {
        this.attempt = 0;
    }

    // 시도 횟수를 증가시키는 기능
    public void plusAttempt() {
        attempt++;
    }

    public int getAttempt() {
        return attempt;
    }
}
