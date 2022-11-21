package bridge;

public class NumberGeneratorDependencyContainerImpl implements NumberGeneratorDependencyContainer {

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
