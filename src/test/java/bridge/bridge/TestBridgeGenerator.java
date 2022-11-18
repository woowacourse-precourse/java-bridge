package bridge.bridge;

import bridge.BridgeNumberGenerator;

import java.util.List;

public class TestBridgeGenerator implements BridgeNumberGenerator {
    private final List<Integer> bridge;
    private int pointer;

    TestBridgeGenerator(List<Integer> bridge) {
        this.bridge = bridge;
        this.pointer = 0;
    }

    @Override
    public int generate() {
        return bridge.get(pointer++);
    }
}
