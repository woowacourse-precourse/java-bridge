package bridge.Domain;

public class GameRound {
    private Integer round;

    public GameRound(Integer round) {
        this.round = round;
    }

    public static GameRound firstRound() {
        return new GameRound(1);
    }

    public Integer getRound() {
        return round;
    }

    public void nextRount() {
        round++;
    }
}
