package bridge.domain;

public class Player {
    private final int roundCount;
    private final int gamePlayingCount;

    public Player(int roundCount, int gamePlayingCount) {
        this.roundCount = roundCount;
        this.gamePlayingCount = gamePlayingCount;
    }
}
