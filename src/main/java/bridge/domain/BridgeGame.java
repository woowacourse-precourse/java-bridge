package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class BridgeGame {
    private final GameUser gameUser = new GameUser();
    private final Counter gameCounter = new Counter();
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
            gameStatus.setCount(gameCounter.getCount());
        }
        return gameStatus;
    }

    public void retry() {
        gameCounter.addCount();
        gameUser.reset();
    }

    public void move(String moving) {
        gameUser.move(moving);
    }

    private boolean isGameOver() {
        return gameUser.getOffFrom(answerBridge) ||
                gameUser.isOnTheFinalBlock(answerBridge);
    }
}
