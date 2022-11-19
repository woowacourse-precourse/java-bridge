package bridge.domain.player;

public class GamePlayer {
    private int position;
    private int trial;

    private GamePlayer(int position, int trial) {
        this.position = position;
        this.trial = trial;
    }

    public static GamePlayer withDefaultValue() {
        return new GamePlayer(0, 1);
    }
}
