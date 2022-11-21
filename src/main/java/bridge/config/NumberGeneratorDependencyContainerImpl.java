package bridge.config;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class NumberGeneratorDependencyContainerImpl implements NumberGeneratorDependencyContainer {

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
