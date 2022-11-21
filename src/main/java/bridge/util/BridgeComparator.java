package bridge.util;

import bridge.domain.Bridge;
import bridge.domain.Result;

public class BridgeComparator {
    public static Result compareBridges(Bridge realBridges, Bridge selectedBridges) {
        for (int index = 0; index < selectedBridges.getSize(); index++) {
            String realBridge = realBridges.getBridgeByIndex(index);
            String selectedBridge = selectedBridges.getBridgeByIndex(index);
            if (!realBridge.equals(selectedBridge)) {
                return Result.fail(selectedBridges);
            }
        }
        return Result.success(selectedBridges);
    }
}
