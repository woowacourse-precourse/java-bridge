package bridge.utill;

import bridge.BridgeNumberGenerator;

import java.util.List;

public class TestBridgeGenerator implements BridgeNumberGenerator {
    private final List<Integer> bridge;
    private int pointer = 0;

    public TestBridgeGenerator(List<Integer> bridge) {
        this.bridge = bridge;
    }

    @Override
    public int generate() {
        return this.bridge.get(pointer++);
    }
}
