package bridge.mokup;

import bridge.BridgeNumberGenerator;

public class TestBridgeNumberGenerator implements BridgeNumberGenerator {
    private int prev;

    public TestBridgeNumberGenerator(int i) {
        prev = i % 2;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    @Override
    public int generate() {
        return prev = (prev + 1) % 2;
    }
}
