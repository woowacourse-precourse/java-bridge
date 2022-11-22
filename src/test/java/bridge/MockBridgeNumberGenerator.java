package bridge;

import java.util.List;

public class MockBridgeNumberGenerator implements BridgeNumberGenerator {
    private final List<Integer> expected;
    private int current;

    public MockBridgeNumberGenerator() {
        expected = List.of(1, 1, 1);
        current = 0;
    }

    @Override
    public int generate() {
        return expected.get(current++);
    }
}
