package bridge;

import bridge.exception.Validator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameService gameService = new BridgeGameService();

    public List<String> getBridge(int size) {
        return gameService.createBridge(size);
    }

    public MessageToResult move(List<String> bridge,
                        String moveMessage) {
        boolean isCorrect = gameService.isCorrectMove(bridge, moveMessage);
        return new MessageToResult(moveMessage, isCorrect);
    }

    public boolean retry(String retryMessage) {
        return gameService.isRetry(retryMessage);
    }

    public boolean isGameClear(List<String> bridge) {
        return gameService.isGameClear(bridge);
    }

    public FinalMessage getResult() {
        return gameService.getFinalMessage();
    }
}
