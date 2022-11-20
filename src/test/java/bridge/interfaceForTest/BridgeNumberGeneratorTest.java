package bridge.interfaceForTest;

import bridge.BridgeNumberGenerator;

public class BridgeNumberGeneratorTest implements BridgeNumberGenerator {
    @Override
    public int generate() {
        return 1;
    }
}
