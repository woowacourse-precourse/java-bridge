package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class BridgeGame {
    private final GameUser gameUser = new GameUser();
    private final Counter retryCounter = new Counter();
    private Bridge answerBridge;

    public void initAnswerBridge(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        answerBridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public GameStatus getMovingResult(String moving) {
        move(moving);
        GameStatus gameStatus = new GameStatus(gameUser);
        if (isGameOver()) {
            gameStatus.setFlag(gameUser, answerBridge);
            gameStatus.setCount(retryCounter.getCount());
        }
        return gameStatus;
    }

    public void retry() {
        retryCounter.addCount();
        gameUser.reset();
    }

    public void move(String moving) {
        gameUser.move(moving);
    }

    private boolean isGameOver() {
        return gameUser.isGetOutFrom(answerBridge) ||
                gameUser.isOnTheFinalBlockOf(answerBridge);
    }
}
