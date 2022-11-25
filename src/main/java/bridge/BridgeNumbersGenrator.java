package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

public class BridgeNumbersGenrator implements BridgeNumberGenerator{
    private List<Integer> numbers;
    BridgeNumbersGenrator(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        numbers = newArrayList();
        for (int i = 0 ;i< size;i++) {
            numbers.add(bridgeRandomNumberGenerator.generate());
        }
    }
    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
