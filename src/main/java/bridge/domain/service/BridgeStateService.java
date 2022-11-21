package bridge.domain.service;

import bridge.domain.resources.bridge.Bridge;
import bridge.domain.resources.Move;
import bridge.domain.resources.converter.ConvertBridgeMap;


public class BridgeStateService {

    public void compare(final Move move, final Bridge bridge, final BridgeMap bridgeMap) {
        String upOrDown = move.getMove();
        bridgeMap.add(upOrDown);
        if (bridge.isStepOk(upOrDown, bridgeMap.getInputCount() - 1)) {
            bridgeMap.flagUp();
        }
        if (!bridge.isStepOk(upOrDown, bridgeMap.getInputCount() - 1)){
            bridgeMap.flagDown();
        }
    }

    public String mapService(final BridgeMap bridgeMap) {
        ConvertBridgeMap convertBridgeMap = new ConvertBridgeMap(bridgeMap);
        return convertBridgeMap.makePrinted(bridgeMap);
    }
}