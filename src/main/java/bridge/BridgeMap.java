package bridge;

import bridge.constant.MoveResult;
import bridge.constant.BridgeMove;

public class BridgeMap {

    private final BridgeMove bridgeMove;

    private final MoveResult moveResult;

    public BridgeMap(BridgeMove bridgeMove, MoveResult moveResult) {
        this.bridgeMove = bridgeMove;
        this.moveResult = moveResult;
    }

    public BridgeMove getBridgeMove() {
        return bridgeMove;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
