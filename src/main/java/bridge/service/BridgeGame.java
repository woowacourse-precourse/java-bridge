package bridge.service;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeBlock;
import bridge.domain.bridge.Phase;
import bridge.domain.result.RetryCommand;
import bridge.domain.result.BridgeResult;
import bridge.domain.result.GameResult;
import bridge.domain.result.MovingResult;

import static bridge.domain.result.RetryCommand.*;

public class BridgeGame {

    public static final String QUIT_COMMAND = "Q";
    public static final String RETRY_COMMAND = "R";

    public MovingResult move(Bridge bridge, BridgeBlock bridgeBlock, Phase phase) {
        if (bridge.isSameBy(bridgeBlock, phase)) {
            phase.nextPhase();
            return new MovingResult(bridgeBlock, "O");
        }
        phase.resetPhase();
        return new MovingResult(bridgeBlock, "X");
    }

    public void retry(BridgeResult bridgeResult, GameResult gameResult, RetryCommand retryCommand) {
        if (retryCommand.equals(Q)) {
            gameResult.gameOver();
        }
        if (retryCommand.equals(R)) {
            gameResult.plusTryCnt();
            bridgeResult.clearMap();
        }
    }
}
