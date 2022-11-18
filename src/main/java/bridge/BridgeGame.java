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
            // 게임 종료되는 경우는. 1. 틀렸거나, 2. 답을 맞췄거나
            gameStatus.setFlag(gameUser, answerBridge);
        }
        return gameStatus;
    }

    public void move(String moving) {
        gameUser.move(moving);
    }

    private boolean isGameOver() {
        return gameUser.hasDifferentBridge(answerBridge) ||
                gameUser.hasBridgeLength(answerBridge.length());
    }

    public void retry() {
        gameUser.reset();
    }
}
