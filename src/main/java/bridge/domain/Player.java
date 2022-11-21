package bridge.domain;

import java.util.List;

public class Player {

    private final GamePlayCount gamePlayCount;
    private final BridgeGameResult bridgeGameResult;
    private Round round;

    public Player() {
        this(GamePlayCount.firstGame(), Round.firstRound(), new BridgeGameResult());
    }

    public Player(GamePlayCount gamePlayCount, Round round, BridgeGameResult bridgeGameResult) {
        this.gamePlayCount = gamePlayCount;
        this.round = round;
        this.bridgeGameResult = bridgeGameResult;
    }

    public void move(BridgeGame bridgeGame, Direction direction) {
        MoveResult result = bridgeGame.move(round, direction);
        bridgeGameResult.addResult(round, new PlayerMove(result, direction));
        this.round = round.nextRound();
    }

    public void reset() {
        bridgeGameResult.reset();
        this.round = Round.firstRound();
        gamePlayCount.nextGame();
    }

    public List<List<MoveResult>> getBridgeGameResult() {
        return bridgeGameResult.getResult();
    }

    public Integer getGamePlayCount() {
        return gamePlayCount.getCount();
    }

    public Victory checkGamePassed() {
        return bridgeGameResult.checkPassed();
    }
}
