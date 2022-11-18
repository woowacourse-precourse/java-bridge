package bridge;

import java.util.List;

public class BridgeGame {
    private Bridge answerBridge;
    private GameUser gameUser;

    public void initialize(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        answerBridge = new Bridge(bridgeMaker.makeBridge(size));
        gameUser = new GameUser();
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

    private boolean isGameOver() {
        return !gameUser.hasSameBridge(answerBridge) ||
                gameUser.hasBridgeLength(answerBridge.length());
    }

    public void retry() {
        gameUser.reset();
    }
}
