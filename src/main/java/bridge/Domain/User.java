package bridge.Domain;

import java.util.List;

public class User {

    private final GameRound gameRound;
    private final BridgeGame bridgeGame;
    private TryCount tryCount;

    public User() {
        this(TryCount.firstTry(), GameRound.firstRound(), new BridgeGame());
    }

    public User(TryCount tryCount, GameRound gameRound, BridgeGame bridgeGame) {
        this.tryCount = tryCount;
        this.gameRound = gameRound;
        this.bridgeGame = bridgeGame;
    }

    public void userMove(BridgeGame bridgeGame, DirectionCommand directionCommand) {
        GameResult result = bridgeGame.move(tryCount, directionCommand);
        bridgeGame.addMove(tryCount, new MoveResult(result, directionCommand));
        this.tryCount = tryCount.passNextCount();
    }

    public List<List<GameResult>> getUserGameResult() {
        return bridgeGame.getResult();
    }

    public Integer getUserGameRound() {
        return gameRound.getRound();
    }

    public FinalGameResult checkUserProgress() {
        return bridgeGame.checkPass();
    }

    public void userReset() {
        bridgeGame.reset();
        this.tryCount = TryCount.firstTry();
        gameRound.nextRount();
    }

}
