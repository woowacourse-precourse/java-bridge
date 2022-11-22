package bridge.domain;

public class Player {
    private static final int FIRST_GAME_COUNT = 1;

    private final Round round;
    private final BridgeGameResult gameResult;
    private int gamePlayCount;

    public Player() {
        this.round = Round.firstRound();
        this.gameResult = new BridgeGameResult();
        this.gamePlayCount = FIRST_GAME_COUNT;
    }
}
