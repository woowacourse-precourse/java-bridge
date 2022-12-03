package bridge;

import java.util.List;

class TestNumberGenerator implements BridgeNumberGenerator {
    private final List<Integer> numbers;

    TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}