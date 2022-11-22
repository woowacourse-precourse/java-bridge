package bridge.domain.bridge;

import bridge.domain.bridge.maker.BridgeMaker;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import java.util.List;

public class Bridge {
    private final List<String> madeBridge;
    private final BridgeSize bridgeSize;
    private BridgeIndex bridgeIndex;

    public Bridge(BridgeMaker bridgeMaker, BridgeSize bridgeSize) {
        this.madeBridge = bridgeMaker.makeBridge(bridgeSize.size());
        this.bridgeSize = bridgeSize;
        this.bridgeIndex = BridgeIndex.generateZeroIndex();
    }

    public void reset() {
        this.bridgeIndex = BridgeIndex.generateZeroIndex();
    }

    public SurviveStatus next(BridgePosition targetPosition) {
        return SurviveStatus.getSurviveStatusByCompareBridgePosition(
                BridgePosition.convertCodeToPosition(getNowBridgePositionCode()),
                targetPosition
        );
    }

    public boolean canMove() {
        return bridgeIndex.isLessThan(bridgeSize.size());
    }

    public boolean canNotMove() {
        return !canMove();
    }

    private String getNowBridgePositionCode() {
        return madeBridge.get(bridgeIndex.getAndIncrement());
    }
}
