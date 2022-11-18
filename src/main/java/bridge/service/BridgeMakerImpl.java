package bridge.service;

import java.util.List;

public class BridgeMakerImpl implements BridgeMaker{

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMakerImpl(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    @Override
    public List<String> makeBridge(int size) {
        return null;
    }
}
