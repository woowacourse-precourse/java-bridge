package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

public class BridgeNumbersGenrator implements BridgeNumberGenerator{
    private  List<Integer> numbers;
    BridgeNumbersGenrator(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.numbers = newArrayList();
        for (int i = 0 ;i< size;i++) {
            this.numbers.add(bridgeRandomNumberGenerator.generate());
        }
    }
    @Override
    public int generate() {
        return 0;
    }

}
