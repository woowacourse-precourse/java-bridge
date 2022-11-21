package bridge.domain;

import java.util.List;

public class GameResult {
    private final MoveResult moveResult;
    private final List<BridgeState> bridgeStates;

    public GameResult(MoveResult moveResult, List<BridgeState> bridgeStates) {
        this.moveResult = moveResult;
        this.bridgeStates = bridgeStates;
    }

    public List<BridgeState> getBridgeStates() {
        return bridgeStates;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
