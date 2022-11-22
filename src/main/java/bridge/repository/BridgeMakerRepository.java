package bridge.repository;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import java.util.List;

public class BridgeMakerRepository extends BridgeMaker {
    public BridgeMakerRepository(BridgeNumberGenerator bridgeNumberGenerator) {
        super(bridgeNumberGenerator);
    }

    @Override
    public List<String> makeBridge(int size) {
        return super.makeBridge(size);
    }
}