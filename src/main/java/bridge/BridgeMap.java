package bridge;

import bridge.constant.BridgeMatch;
import bridge.constant.BridgeMove;

public class BridgeMap {

    private final BridgeMove bridgeMove;

    private final BridgeMatch bridgeMatch;

    public BridgeMap(BridgeMove bridgeMove, BridgeMatch bridgeMatch) {
        this.bridgeMove = bridgeMove;
        this.bridgeMatch = bridgeMatch;
    }

    public BridgeMove getBridgeMove() {
        return bridgeMove;
    }

    public BridgeMatch getBridgeMatch() {
        return bridgeMatch;
    }
}
