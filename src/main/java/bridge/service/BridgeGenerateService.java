package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import java.util.List;

public class BridgeGenerateService {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public List<String> generateBridgeBySize(int size) {
        return bridgeMaker.makeBridge(size);
    }
}
