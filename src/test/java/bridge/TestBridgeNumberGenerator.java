package bridge;

import java.util.List;

public class TestBridgeNumberGenerator implements BridgeNumberGenerator {

    private final List<Integer> numbers;

    public TestBridgeNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
