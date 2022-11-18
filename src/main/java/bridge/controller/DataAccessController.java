package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeStatus;
import bridge.service.BridgeRandomNumberGenerator;


public class DataAccessController {
    private final static BridgeStatus BRIDGE_STATUS = new BridgeStatus();
    private final static BridgeMaker BRIDGE_MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static Bridge bridge;


    public void updateBridgeStatus(
            final int round,
            final String userAnswer
    ) {
        BRIDGE_STATUS.updateBridgeMap(bridge.getBridgeAnswer(round), userAnswer);
    }

    public BridgeStatus getBridgeStatus() {
        BRIDGE_STATUS.createMessage();
        return BRIDGE_STATUS;
    }

    public int getBridgeSize() {
        return bridge.getBridgeSize();
    }

    public void previousBridgeStatus() {
        BRIDGE_STATUS.switchSuccess();
        BRIDGE_STATUS.undoStatus(4);
    }

    public void makeBridge(final int bridgeSize) {
        bridge = new Bridge(BRIDGE_MAKER.makeBridge(bridgeSize));
    }
}