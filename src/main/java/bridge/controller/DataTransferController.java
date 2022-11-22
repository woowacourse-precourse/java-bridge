package bridge.controller;

import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.domain.BridgeStatus;
import bridge.BridgeRandomNumberGenerator;


public class DataTransferController {
    private final BridgeStatus bridgeStatus = new BridgeStatus();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;


    public void updateBridgeStatus(
            final int round,
            final String userAnswer
    ) {
        bridgeStatus.updateBridgeMap(bridge.getBridgeAnswer(round), userAnswer);
    }

    public BridgeStatus getBridgeStatus() {
        bridgeStatus.createMessage();
        return bridgeStatus;
    }

    public int getBridgeSize() {
        return bridge.getBridgeSize();
    }

    public void resetBridgeStatus() {
        bridgeStatus.reset();
    }

    public void makeBridge(final int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}