package bridge.domain;

public class GamePlayCount {

    private static final int PLAY_COUNT_LOWER_BOUND = 1;

    private Integer count;

    private GamePlayCount(Integer count) {
        this.count = count;
    }

    public static GamePlayCount firstGame() {
        return new GamePlayCount(PLAY_COUNT_LOWER_BOUND);
    }

    public void nextGame() {
        count++;
    }

    public Integer getCount() {
        return count;
    }
}
