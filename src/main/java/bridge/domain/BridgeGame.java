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

    public GameStatusDTO getMovingResult(String moving) {
        move(moving);

        GameStatusDTO gameStatusDTO = new GameStatusDTO(gameUser);
        if (isGameOver()) {
            gameStatusDTO.setCount(retryCounter.getCount());
            gameStatusDTO.setFlag(GameFlag.getGameFlagWhenGameOver(gameUser, answerBridge));
        }
        return gameStatusDTO;
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
