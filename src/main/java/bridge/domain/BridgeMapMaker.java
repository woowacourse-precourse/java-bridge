package bridge.domain;

import java.util.List;

public class BridgeMapMaker {
    public BridgeMap makeBridgeMap(final List<String> movingStatus, final String side) {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());
        bridgeMap.concatComponent(BridgeComponent.BRIDGE_BEGINNING);

        bridgeMap.concatComponent(BridgeComponent.BRIDGE_END);
        return bridgeMap;
    }
}
