package bridge;

import bridge.exception.Validator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Validator validator = new Validator();
    private final BridgeGameService gameService = new BridgeGameService();

    public List<String> getBridge(int size) {
        validator.validateBridgeSize(size);
        return gameService.createBridge(size);
    }

    public MessageToResult move(List<String> bridge,
                        String moveMessage) {
        validator.validateMoveMessage(moveMessage);
        boolean isCorrect = gameService.isCorrectMove(bridge, moveMessage);
        return new MessageToResult(moveMessage, isCorrect);
    }

    public boolean retry(String retryMessage) {
        validator.validateGameRestartMessage(retryMessage);
        return gameService.isRetry(retryMessage);
    }
    }
}
