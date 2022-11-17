package bridge.mock;

import bridge.system.util.BridgeNumberGenerator;

import java.util.List;

public class MockNumberGenerator implements BridgeNumberGenerator {
    private final List<Integer> numbers;

    public MockNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
