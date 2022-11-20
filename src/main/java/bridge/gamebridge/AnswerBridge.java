package bridge.gamebridge;

import static bridge.result.GameStatus.FAIL;
import static bridge.result.GameStatus.PROGRESS;
import static bridge.result.GameStatus.SUCCESS;

import bridge.domain.Bridge;
import bridge.result.GameStatus;
import bridge.result.Result;

public class AnswerBridge {

    private final Bridge bridge;

    public AnswerBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public Result checkBridge(Bridge otherBridge) {
        return new Result(otherBridge.getSquares(), determineGameStatus(otherBridge));
    }

    private GameStatus determineGameStatus(Bridge otherBridge) {
        if (bridge.equals(otherBridge)) {
            return SUCCESS;
        } else if (bridge.isPassableBridge(otherBridge)) {
            return PROGRESS;
        }
        return FAIL;
    }
}
