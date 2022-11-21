package bridge.domain;

import bridge.domain.constant.BridgeComponent;

import java.util.List;
public class BridgeMapMaker {
    private final List<String> movingStatus;
    private final String side;

    public BridgeMapMaker(List<String> movingStatus, String side){
        this.movingStatus = movingStatus;
        this.side = side;
    }

    public BridgeMap makeBridgeMap() {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());
        bridgeMap.concatComponent(BridgeComponent.BRIDGE_BEGINNING);
        bridgeMap.concatComponent(bridgeContent());
        bridgeMap.deleteLastComponent(BridgeComponent.BRIDGE_SEPARATOR);
        bridgeMap.concatComponent(BridgeComponent.BRIDGE_END);
        return bridgeMap;
    }

    private String bridgeContent() {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());
        for (String moving : movingStatus) {
            bridgeMap.concatComponent(crossOrNot(moving));
            bridgeMap.concatComponent(BridgeComponent.BRIDGE_SEPARATOR);
        }
        return bridgeMap.toString();
    }

    private String crossOrNot(final String moving) {
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
