package bridge.domain;

import bridge.domain.constant.BridgeComponent;

import java.util.List;

public class BridgeMapGenerator {

    private final List<String> bridgeStatus;
    private final String side;

    public BridgeMapGenerator(List<String> bridgeStatus, String side) {
        this.bridgeStatus = bridgeStatus;
        this.side = side;
    }

    public BridgeMap makeBridgeMap() {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());

        bridgeMap.appendComponent(BridgeComponent.BRIDGE_BEGIN.getComponent());
        bridgeMap.appendComponent(bridgeContent());
        bridgeMap.deleteLastComponent(BridgeComponent.BRIDGE_SEPARATOR.getComponent());
        bridgeMap.appendComponent(BridgeComponent.BRIDGE_END.getComponent());
        return bridgeMap;
    }

    private String bridgeContent() {
        BridgeMap bridgeMap = new BridgeMap(new StringBuilder());

        for (String bridgeMoving : bridgeStatus) {
            bridgeMap.appendComponent(printAvailable(bridgeMoving));
            bridgeMap.appendComponent(BridgeComponent.BRIDGE_SEPARATOR.getComponent());
        }
        return bridgeMap.toString();
    }

    private String printAvailable(final String bridgeMoving) {
        String fail = BridgeMapper.FAIL.getUpDownInformation() + side;
        if (bridgeMoving.equals(side)) {
            return BridgeComponent.AVAILABLE_CROSS.getComponent();
        }
        if (bridgeMoving.equals(fail)) {
            return BridgeComponent.UNAVAILABLE_CROSS.getComponent();
        }
        return BridgeComponent.BLANK.getComponent();
    }
}
