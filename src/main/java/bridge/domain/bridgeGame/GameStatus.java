package bridge.domain.bridgeGame;

import bridge.domain.bridgeGame.gameStatus.GameStatics;
import bridge.domain.bridgeGame.gameStatus.Distance;
import bridge.domain.bridgeGame.gameStatus.gameStatics.GameResult;

import java.util.Queue;

public class GameStatus {
    private final Distance distance;
    private final GameStatics gameStatics;

    private GameStatus(Distance distance, GameStatics gameStatics) {
        this.distance = distance;
        this.gameStatics = gameStatics;
    }

    public static GameStatus initStatus() {
        return new GameStatus(Distance.initDistance(), GameStatics.initStatics());
    }

    public void retryGame() {
        gameStatics.updateByRetry();
    }

    public void resetDistance() {
        distance.reset();
    }

    public int getAndIncreaseDistance() {
        int currentDistance = distance.toInt();
        distance.increaseDistance();

        return currentDistance;
    }

    public void updateGameResult(boolean gameCleared) {
        gameStatics.updateGameResult(gameCleared);
    }

    public int distance() {
        return distance.toInt();
    }

    public GameResult gameResult() {
        return gameStatics.result();
    }

    public Queue<String> getGameStatics() {
        return gameStatics.getStatics();
    }
}
