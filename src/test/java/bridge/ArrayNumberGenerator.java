package bridge;

import java.util.List;

class ArrayNumberGenerator implements BridgeNumberGenerator {
    private List<Integer> numbers;
    int idx = 0;

    public ArrayNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int generate() {
        return numbers.get(this.idx++);
    }
}
