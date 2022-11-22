package bridge.domain;

public class Player {
    private static final int FIRST_GAME_COUNT = 1;

    private Round round;
    private final BridgeGameResult bridgeGameResult;
    private int gamePlayCount;

    public Player() {
        this.round = Round.firstRound();
        this.bridgeGameResult = new BridgeGameResult();
        this.gamePlayCount = FIRST_GAME_COUNT;
    }

    public void move(BridgeGame bridgeGame, Direction direction) {
        MovingResult result = bridgeGame.move(round, direction);
        bridgeGameResult.addResult(round, result, direction);
        this.round = round.nextRound();
    }

    public int getGamePlayCount() {
        return this.gamePlayCount;
    }
}
