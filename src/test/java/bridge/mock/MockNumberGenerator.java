package bridge.mock;

import bridge.mock.exception.MockInputNotFoundException;
import bridge.BridgeNumberGenerator;

import java.util.Iterator;
import java.util.List;

public class MockNumberGenerator implements BridgeNumberGenerator {
    private final Iterator<Integer> numbers;

    public MockNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers.iterator();
    }

    @Override
    public int generate() {
        if (this.numbers.hasNext()) {
            return numbers.next();
        }
        throw new MockInputNotFoundException();
    }
}
