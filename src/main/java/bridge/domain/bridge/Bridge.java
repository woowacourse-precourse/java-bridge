package bridge.domain.bridge;

import bridge.domain.bridge.maker.BridgeMaker;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import java.util.List;

public class Bridge {
    private final List<String> madeBridge;
    private final BridgeSize bridgeSize;
    private Integer index;

    public Bridge(BridgeMaker bridgeMaker, BridgeSize bridgeSize) {
        this.madeBridge = bridgeMaker.makeBridge(bridgeSize.size());
        this.bridgeSize = bridgeSize;
        this.reset();
    }

    public void reset() {
        this.index = 0;
    }

    public SurviveStatus next(BridgePosition targetPosition) {
        var originalPosition = BridgePosition.convertCodeToPosition(madeBridge.get(index++));
        return SurviveStatus.convertValueToStatus(originalPosition, targetPosition);
    }

    public boolean canMove() {
        return index < bridgeSize.size();
    }

    public boolean canNotMove() {
        return !canMove();
    }
}
