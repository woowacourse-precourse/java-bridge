package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridge;

import java.util.List;

public class BridgeMakingService {
    private final BridgeMaker bridgeMaker;

    public BridgeMakingService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public Bridge makeSizeOf(int size){
        List<String> made = bridgeMaker.makeBridge(size);
        return new Bridge(made);
    }
}
