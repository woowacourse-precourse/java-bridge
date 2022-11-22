package testBridgeGenerator;

import bridge.BridgeNumberGenerator;

import java.util.List;

public class TestBridgeGenerator implements BridgeNumberGenerator {

    private final List<Integer> bridge;
    private int index;

    public TestBridgeGenerator(List<Integer> bridge) {
        this.bridge = bridge;
        index = 0;
    }

    @Override
    public int generate() {
        Integer value = bridge.get(index);
        index += 1;
        return value;
    }
}
