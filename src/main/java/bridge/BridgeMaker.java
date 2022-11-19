package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<Integer> randomNumbers = makeRandomIntegers(size);
        return randomNumbers.stream()
                .map(this::changeUpDown)
                .collect(Collectors.toList());
    }

    private List<Integer> makeRandomIntegers(int size) {
        List<Integer> random = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            random.add(bridgeNumberGenerator.generate());
        }
        return random;
    }

    private String changeUpDown(int random) {
        if (random == 0) {
            return "D";
        }
        return "U";
    }
}
