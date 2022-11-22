package bridge.mock;

import bridge.BridgeNumberGenerator;
import bridge.config.NumberGeneratorDependencyContainer;

import java.util.List;

public class MockNumberGeneratorDependencyContainerImpl implements NumberGeneratorDependencyContainer {

    private List<Integer> bridgeNumbers;

    public MockNumberGeneratorDependencyContainerImpl(List<Integer> bridgeNumbers) {
        this.bridgeNumbers = bridgeNumbers;
    }

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new MockBridgeNumberGenerator(bridgeNumbers);
    }
}
