package bridge.domain.bridgeGame.gameStatus;

import bridge.domain.bridgeGame.gameStatus.gameStatics.AttemptCount;
import bridge.domain.bridgeGame.gameStatus.gameStatics.GameResult;

import java.util.LinkedList;
import java.util.Queue;

public class GameStatics {
    private AttemptCount attemptCount;
    private GameResult gameResult;

    private GameStatics(AttemptCount attemptCount, GameResult gameResult) {
        this.attemptCount = attemptCount;
        this.gameResult = gameResult;
    }

    public static GameStatics initStatics() {
        return new GameStatics(AttemptCount.initCount(), GameResult.NOT_EXIST);
    }

    public void updateGameResult(boolean gameCleared) {
        gameResult = GameResult.get(gameCleared);
    }

    public void updateByRetry() {
        attemptCount = attemptCount.increaseCount();
        gameResult = GameResult.NOT_EXIST;
    }

    public Queue<String> getStatics() {
        Queue<String> gameStatics = new LinkedList<>();
        gameStatics.add(gameResult.toString());
        gameStatics.add(attemptCount.toString());

        return gameStatics;
    }

    public GameResult result() {
        return gameResult;
    }
}
