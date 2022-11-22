package bridge;

import java.util.ArrayList;
import java.util.List;

public class TestNumberGenerator implements BridgeNumberGenerator {

    private final List<Integer> numbers;

    TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }

    public static TestNumberGenerator from(List<Integer> numbers) {
        return new TestNumberGenerator(new ArrayList<>(numbers));
    }
}
