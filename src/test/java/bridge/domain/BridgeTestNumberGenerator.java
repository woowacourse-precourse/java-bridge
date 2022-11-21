package bridge.domain;

import java.util.List;

public class BridgeTestNumberGenerator  implements BridgeNumberGenerator {
    private final List<Integer> numbers;

    BridgeTestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }

}
