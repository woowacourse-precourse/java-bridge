package bridge.domain;

import bridge.common.Code;

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

    public void move(BridgeGame bridgeGame, Move move) {
        MoveResult result = bridgeGame.move(round, move);
        bridgeGameResult.addResult(round, PlayerMove.of(move, result));
        this.round = round.nextRound();
    }

    public void retry() {
        this.round = Round.firstRound();
        bridgeGameResult.reset();
        increaseGamePlayCount();
    }

    private void increaseGamePlayCount() {
        this.gamePlayCount++;
    }

    public Code checkGameSuccess() {
        return bridgeGameResult.checkGameSuccess();
    }

    public int getGamePlayCount() {
        return this.gamePlayCount;
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }
}
