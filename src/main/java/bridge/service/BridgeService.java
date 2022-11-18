package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ViewStatus;
import bridge.domain.Bridge;
import bridge.dto.MakeBridgeResponse;

public class BridgeService {

    private Bridge bridge;
    public MakeBridgeResponse makeBridge(Integer size) {
        BridgeMaker bridgeMaker =
            new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = Bridge.from(bridgeMaker.makeBridge(size));

        return MakeBridgeResponse.from(ViewStatus.DETERMINE_MOVE);
    }
}
