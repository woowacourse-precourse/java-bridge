package bridge.domain;

public class BridgeGameRound {

    private int round = 1;

    public void nextRound() {
        round++;
    }

    public int checkRound() {
        return this.round;
    }
}
