package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class BridgeGame {
    private Bridge answerBridge;
    private GameUser gameUser;
    private Counter gameCounter;

    public void initialize(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        answerBridge = new Bridge(bridgeMaker.makeBridge(size));
        gameUser = new GameUser();
        gameCounter = new Counter();
    }

    public GameStatus getMovingResult(String moving) {
        move(moving);
        GameStatus gameStatus = new GameStatus(gameUser);
        if (isGameOver()) {
            gameStatus.setFlag(gameUser, answerBridge);
        }
        return gameStatus;
    }

    public void move(String moving) {
        gameUser.move(moving);
    }

    public int getCount() {
        return gameCounter.getCount();
    }

    private boolean isGameOver() {
        return gameUser.hasBridgeDifferentFrom(answerBridge) ||
                gameUser.hasBridgeLength(answerBridge.length());
    }

    public void retry() {
        gameCounter.addCount();
        gameUser.reset();
    }
}
