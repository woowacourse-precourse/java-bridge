package bridge.service;

import bridge.utils.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import java.util.List;

public class BridgeGenerateService {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public List<String> generateBridgeBySize(int size) {
        return bridgeMaker.makeBridge(size);
    }
}
