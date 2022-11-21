package bridge.domain.bridgeGame.gameStatics;

import java.util.LinkedList;
import java.util.Queue;

public class GameStatics {
    private AttemptCount attemptCount;
    private CrossResult crossResult;

    private GameStatics(AttemptCount attemptCount, CrossResult crossResult) {
        this.attemptCount = attemptCount;
        this.crossResult = crossResult;
    }

    public static GameStatics initStatics() {
        return new GameStatics(AttemptCount.initCount(), CrossResult.FAIL);
    }

    public void updateCrossResult(boolean crossSuccess) {
        crossResult = CrossResult.get(crossSuccess);
    }

    public boolean getCrossResult() {
        return crossResult.getValue();
    }

    public void increaseAttemptCount() {
        attemptCount = attemptCount.increaseCount();
    }

    public Queue<String> getStaticsString() {
        Queue<String> gameStatics = new LinkedList<>();
        gameStatics.add(crossResult.toString());
        gameStatics.add(attemptCount.toString());

        return gameStatics;
    }
}
