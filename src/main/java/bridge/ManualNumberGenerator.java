package bridge;

import java.util.List;

public class ManualNumberGenerator implements BridgeNumberGenerator {

    private final List<Integer> numbers;

    public ManualNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
