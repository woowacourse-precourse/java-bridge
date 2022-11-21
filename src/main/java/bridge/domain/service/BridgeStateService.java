package bridge.domain.service;

import bridge.domain.resources.bridge.Bridge;
import bridge.domain.resources.Move;
import bridge.domain.resources.converter.ConvertBridgeMap;


public class BridgeStateService {

    public void compare(Move move, Bridge bridge, BridgeMap bridgeMap) {
        String upOrDown = move.getMove();
        bridgeMap.add(upOrDown);
        if (bridge.isStepOk(upOrDown, bridgeMap.getInputCount() - 1)) {
            bridgeMap.flagUp();
        }
        if (!bridge.isStepOk(upOrDown, bridgeMap.getInputCount() - 1)){
            bridgeMap.flagDown();
        }
    }

    public String mapService(BridgeMap bridgeMap) {
        ConvertBridgeMap convertBridgeMap = new ConvertBridgeMap(bridgeMap);
        return convertBridgeMap.makePrinted(bridgeMap);
    }
}