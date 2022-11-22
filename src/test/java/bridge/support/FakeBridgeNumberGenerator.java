package bridge.support;

import bridge.BridgeNumberGenerator;

import java.util.List;

public class FakeBridgeNumberGenerator implements BridgeNumberGenerator {

    private final List<Integer> numbers;

    public FakeBridgeNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
