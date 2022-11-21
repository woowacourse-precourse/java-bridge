package bridge.domain.service;

import bridge.domain.resources.bridge.Bridge;
import bridge.domain.resources.bridge.BridgeMap;
import bridge.domain.resources.Move;


public class BridgeStateService {

    public void compare(Move move, Bridge bridge, BridgeMap bridgeMap) {
        //correct
        String upOrDown = move.getMove();
        // 여기서 String 으로 받는게 맞나?
        if (bridge.isStepOk(upOrDown, bridgeMap.getInputCount().get() - 1)) {
            bridgeMap.add(upOrDown);
            bridgeMap.flagUp();
        }
        //wrong
        else{
            bridgeMap.add(upOrDown);
            bridgeMap.flagDown();
        }
    }
}