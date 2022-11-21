package bridge.domain;

import bridge.domain.constant.BridgeComponent;

import java.util.List;

public class BridgeMapMaker {
    public BridgeMap makeBridgeMap(final List<String> movingStatus, final String side) {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());
        bridgeMap.concatComponent(BridgeComponent.BRIDGE_BEGINNING);
        bridgeMap.concatComponent(bridgeContent(movingStatus, side));
        bridgeMap.deleteLastComponent(BridgeComponent.BRIDGE_SEPARATOR);
        bridgeMap.concatComponent(BridgeComponent.BRIDGE_END);
        return bridgeMap;
    }

    private String bridgeContent(final List<String> movingStatus, final String side) {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());
        for (String moving : movingStatus) {
            bridgeMap.concatComponent(crossOrNot(moving, side));
            bridgeMap.concatComponent(BridgeComponent.BRIDGE_SEPARATOR);
        }
        return bridgeMap.toString();
    }

    private String crossOrNot(final String moving, final String side) {
        String failSide = MovingStatus.FAIL.getMovingKey() + side;
        if (moving.equals(side)) {
            return BridgeComponent.CAN_CROSS;
        }
        if (moving.equals(failSide)) {
            return BridgeComponent.CANNOT_CROSS;
        }
        return BridgeComponent.BLANK;
    }
}
