package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ViewStatus;
import bridge.domain.Bridge;

public class BridgeService {

    private Bridge bridge;
    public ViewStatus makeBridge(Integer size) {
        BridgeMaker bridgeMaker =
            new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = Bridge.from(bridgeMaker.makeBridge(size));

        return ViewStatus.DETERMINE_MOVE;
    }
}
