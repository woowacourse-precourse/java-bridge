package bridge.repository;

import static bridge.exception.Validator.validBridgeLength;

import bridge.BridgeRandomNumberGenerator;
import bridge.maker.BridgeMaker;
import java.util.List;

public class BridgeRepository {

    private List<String> bridge;

    public BridgeRepository(int size) {
        validBridgeLength(size);
        setBridge(size);
    }

    public void setBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }
}
