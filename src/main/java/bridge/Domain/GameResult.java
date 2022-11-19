package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.BridgeType;

public class GameResult {
    private BridgeType position;
    private BridgeResultType result;

    public GameResult(BridgeType position, BridgeResultType result) {
        this.position = position;
        this.result = result;
    }

    public boolean isPositionUpper() {
        return this.position == BridgeType.UP;
    }

    public boolean isMoveSuccess() {
        return this.result == BridgeResultType.POSSIBLE;
    }
}
