package bridge.util;

import bridge.domain.Bridge;
import bridge.domain.GameResult;

public class BridgeComparator {
    public static GameResult compareBridges(Bridge realBridges, Bridge selectedBridges) {
        for (int index = 0; index < selectedBridges.getSize(); index++) {
            String realBridge = realBridges.getBridgeByIndex(index);
            String selectedBridge = selectedBridges.getBridgeByIndex(index);
            if (!realBridge.equals(selectedBridge)) {
                return GameResult.fail(selectedBridges);
            }
        }
        return GameResult.success(selectedBridges);
    }
}
