package bridge.mock;

import bridge.domain.BridgeNumberGenerator;

public class MockBridgeNumberGenerator implements BridgeNumberGenerator {
    private final int mark;

    public MockBridgeNumberGenerator(int mark) {
        this.mark = mark;
    }

    @Override
    public int generate() {
        return mark;
    }
}
