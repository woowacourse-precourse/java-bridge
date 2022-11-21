package bridge.service;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeBlock;
import bridge.domain.bridge.Phase;
import bridge.domain.result.RetryCommand;
import bridge.domain.result.BridgeResult;
import bridge.domain.result.GameState;
import bridge.domain.result.MovingResult;

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

    public void retry(BridgeResult bridgeResult, GameState gameState, RetryCommand retryCommand) {
        if (retryCommand.name().equals(QUIT_COMMAND)) {
            gameState.gameOver();
        }
        if (retryCommand.name().equals(RETRY_COMMAND)) {
            gameState.plusTryCnt();
            bridgeResult.clearMap();
        }
    }
}
